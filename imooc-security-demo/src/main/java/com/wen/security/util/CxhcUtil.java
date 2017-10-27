package com.wen.security.util;

import java.util.List;

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
}
