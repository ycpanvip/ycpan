package com.jnj.tax.utils;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wen.security.util.BeanResult;
import com.wen.security.util.FieldMeta;

public class BeanResultUtil {  
	private static final Logger LOGGER = LoggerFactory.getLogger(BeanResultUtil.class);
	public static BeanResult getBaseResult(Object bean,String path) {
		BeanResult result=getFieldValueResult(bean);
		String xmlString =getBeanString(result,path,getUUID(bean));
		result.setXmlString(xmlString); 
		byte[] bytes=xmlString.getBytes();
		result.setByteString(bytes);
		String newPath=getPath("xml");
		result.setPath(newPath);
		writeXml(bytes,newPath);
		return result;
	}
    /** 
     * author cwq
     * 主要取得 model 的  field 非空  list   以及对应的   
     * @param bean 
     * @return BeanResult 
     */  
    private  static BeanResult getFieldValueResult(Object bean) {
        int count=0;
    	List<String> list=new ArrayList<String>();
		StringBuffer stringParam=new StringBuffer();
		StringBuffer stringField=new StringBuffer();
        Class<?> cls = bean.getClass();  
        Method[] methods = cls.getDeclaredMethods();  
        Field[] fields = cls.getDeclaredFields();  
        for (Field field : fields) {  
            try {  
                String fieldType = field.getType().getSimpleName(); 
                if(!fieldType.equals("String")&&!fieldType.equals("String[]")) {
                    	continue ;
                }
                String fieldGetName = parGetName(field.getName());  
                //校验一次防止不是规范的get  写法出错
                if (!checkGetMet(methods, fieldGetName)) {  
                    continue;  
                }  
                Method fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});  
                Object fieldVal = fieldGetMet.invoke(bean, new Object[] {});  
                FieldMeta meta = field.getAnnotation(FieldMeta.class);
                if(StringUtils.isNotBlank(fieldVal.toString())) {
                	if(count>0) {
            			stringParam.append("&&"+getParam(field.getName(),fieldVal.toString()));
            			stringField.append("+\"_\"+"+field.getName());
                	}else {
                		count++;
            			stringParam.append(getParam(field.getName(),fieldVal.toString()));
            			stringField.append(field.getName());
                	}
                	if(meta!=null) {
            			if(StringUtils.isBlank(meta.name())) {
                    		list.add(field.getName());
            			}else {
            				list.add(meta.name());
            			}
            		}
                }else{
                	if(meta!=null) {
            			if(StringUtils.isNotBlank(meta.value())) {
            				if(count>0) {
                    			stringParam.append("&&"+getParam(field.getName(),meta.value().toString()));
                    			stringField.append("+\"_\"+"+field.getName());
                        	}else {
                        		count++;
                    			stringParam.append(getParam(field.getName(),meta.value().toString()));
                    			stringField.append(field.getName());
                        	}
                    		list.add(field.getName());
            			}
            		}
                }
            } catch (Exception e) {  
                continue;  
            }  
        }  
        return new BeanResult(list,listToString(list),stringParam.toString(),stringField.toString());
    }    
    /**
     * 取得string  stirng  为xml  的内容
     */
    private  static String getBeanString(BeanResult result,String path,String uuid) {
    	return StringInXmlUtil.StringInXml( result.getOrderByString(),result.getStringField(),result.getStringParam(),path,uuid);
    }
    /** 
     * author cwq
     * 判断是否存在某属性的 get方法   
     * @param methods 
     * @param fieldGetMet 
     * @return boolean 
     */  
    private static boolean checkGetMet(Method[] methods, String fieldGetMet) {  
        for (Method met : methods) {  
            if (fieldGetMet.equals(met.getName())) {  
                return true;  
            }  
        }  
        return false;  
    }  
    /** 
     * author cwq
     * 拼接某属性的 get方法  
     * @param fieldName 
     * @return String 
     */  
    private static String parGetName(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        int startIndex = 0;  
        if (fieldName.charAt(0) == '_')  
            startIndex = 1;  
        return "get"  
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()  
                + fieldName.substring(startIndex + 1);  
    }  
    /** 
     * author cwq
     * 拼接 field  和   param  
     * @param getParam 
     * @return String 
     */
	private static String getParam(String field,String param) {
		return field+"=='"+param+"'";
	}
	/**
	 * list  to  String 1,2,3
	 */
	private static String listToString(List<String> list) {
		StringBuffer str=new StringBuffer();
		str.append("");
		if(list!=null&&list.size()>0) {
			for(int i=0;i<list.size()-1;i++) {
				str.append(list.get(i)+",");
			}
			str.append(list.get(list.size()-1));
		}
		return str.toString();
	}
	/**
     * author cwq
 	 * write xml bytes to path
 	 * @param bytes
 	 * @param path
	 */
	private static  void  writeXml(byte[] bytes,String path) {
		File file =new File(path);
        //2.创建文件读入流对象
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			 BufferedOutputStream bos=new BufferedOutputStream(fos);
		        //4.向流中写入数据
		        bos.write(bytes);
		        //5.刷新和关闭流
		        bos.flush();
		        bos.close();
				LOGGER.info(path+"write success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(path+"write error");
			e.printStackTrace();
		}
        //3.创建缓冲流对象加强fos功能
       
	}
	/**
     * author cwq
	 * get  storage  path
	 * @return String
	 */
	private static String getPath(String type) {
		   Calendar instance = Calendar.getInstance();
	        int year = instance.get(Calendar.YEAR);
	        int month = instance.get(Calendar.MONTH)+1;
	        int day = instance.get(Calendar.DATE);
	        int hour=instance.get(Calendar.HOUR);
	        int minute=instance.get(Calendar.MINUTE);
	        int second=instance.get(Calendar.SECOND);
	          String sepa =java.io.File.separator;
	    	String path=System.getProperty("java.io.tmpdir") + System.getProperty("file.separator")+year+sepa+month+sepa+day+sepa;
			File files = new File(path);
			 if (!files.exists()) {
	        try {
	        	files.mkdirs();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	        return path +hour+""+minute+""+second+""+(int)(Math.random()*9000+1000)+"."+type;
	}
	private static String getUUID(Object bean){
        Class<?> cls = bean.getClass();  
        Method[] methods = cls.getDeclaredMethods(); 
        String fieldGetName = "getRequstID";  
        
        //校验一次防止不是规范的get  写法出错
        String str="";
        if (checkGetMet(methods, fieldGetName)) {  
        	try {
        		 Method fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});  
                 Object fieldVal = fieldGetMet.invoke(bean, new Object[] {});  	
                 str=fieldVal.toString();
        	}catch(Exception e) {
        		
        	}
        
        }  
        return str;
	}
}  