package com.wen.security.util;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CxhcUtil {
	//遍历 string array  数组
	public static String getStringByArray(String[] str) {
		if(str!=null&&str.length>0) {
			StringBuffer bf=new StringBuffer();
			for(int i=0;i<str.length;i++) {
				bf.append(str[i]+" ");
			}
			return bf.toString();
		}else {
			return "";
		}
	}
	// 生成  field='param'  格式
	public static String getParam(String field,String param) {
		return field+"='"+param+"'";
	}
	//  list《String》   转string  数组
	public  static String[] listToArray(List<String> list) {
		if(list!=null&&list.size()>0) {
			String str[]=new String[list.size()];
			for(int i=0;i<list.size();i++) {
				str[i]=list.get(i);
			}
			return str;
		}else {
			return null;
		}
	}
	/**
     * author cwq
	 * get  storage  path
	 * @return String
	 */
	
	public static String getPath(String type) {
		Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH)+1;
        int day = instance.get(Calendar.DATE);
        int hour=instance.get(Calendar.HOUR);
        int minute=instance.get(Calendar.MINUTE);
        int second=instance.get(Calendar.SECOND);
	    String sepa =java.io.File.separator;
    	String path=System.getProperty("java.io.tmpdir") +year+sepa+month+sepa+day+sepa;
		File files = new File(path);
		if (!files.exists()) {
			try {
				files.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		String  fixName="";
		if(StringUtils.isNotBlank(type)) {
			fixName="."+type;
		}
	    return path +hour+""+minute+""+second+""+(int)(Math.random()*9000+1000)+fixName;
	}
	/**
	 * 取得文件的后缀名
	 * @param fileName
	 * @return
	 */
	public static String getPrefixName(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}
	/**
     * author cwq  取得文件 原路径
	 * get  storage  path
	 * @return String
	 */
	
	public static String getYuanPath(String type) {
		Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH)+1;
        int day = instance.get(Calendar.DATE);
        int hour=instance.get(Calendar.HOUR);
        int minute=instance.get(Calendar.MINUTE);
        int second=instance.get(Calendar.SECOND);
	    String sepa =java.io.File.separator;
    	String path=System.getProperty("java.io.tmpdir") +year+sepa+month+sepa+day+sepa;
		File files = new File(path);
		if (!files.exists()) {
			try {
				files.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		
	    return path;
	}
}
