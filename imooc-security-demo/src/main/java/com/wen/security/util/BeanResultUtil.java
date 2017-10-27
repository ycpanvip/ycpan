package com.wen.security.util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.commons.lang3.StringUtils;
public class BeanResultUtil {  
    /** 
     * author cwq
     * 主要取得model 的  field 非空  list   以及对应的   
     * @param bean 
     * @return BeanResult 
     */  
    public static BeanResult getFieldValueResult(Object bean) {
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
                	if(list.size()>0) {
            			stringParam.append("&&"+getParam(field.getName(),fieldVal.toString()));
            			stringField.append("_"+field.getName());
                	}else {
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
            				if(list.size()>0) {
                    			stringParam.append("&&"+getParam(field.getName(),meta.value().toString()));
                    			stringField.append("_"+field.getName());
                        	}else {
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
		return field+"='"+param+"'";
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
}  