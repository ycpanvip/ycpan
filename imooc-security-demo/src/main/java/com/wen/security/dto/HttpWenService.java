package com.wen.security.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSON;


public class HttpWenService {
	public static String httpRequest(String requestUrl) {
		 requestUrl = "https://train.qunar.com/dict/open/s2s.do?callback=jQuery17205405101519013015_1509342492073&dptStation=南京&arrStation=上海&date=2017-10-31&type=normal&user=neibu&source=site&start=1&num=500&sort=3&_=1509342492486";
		StringBuffer buffer = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		InputStream inputStream = null;
		HttpURLConnection httpUrlConn = null;
		try {
			// 建立get请求
			URL url = new URL(requestUrl);
			httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");

			// 获取输入流
			inputStream = httpUrlConn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			bufferedReader = new BufferedReader(inputStreamReader);

			// 从输入流读取结果
			buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStreamReader != null) {
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (httpUrlConn != null) {
				httpUrlConn.disconnect();
			}
		}
		return buffer.toString();
	}

	public static String htmlFiter(String html){
		System.out.println(html);
		String result=html.substring(0,html.length()-2).replace("/**/jQuery17205405101519013015_1509342492073(", "");
		
		Map map=(Map)JSON.parse(result);  
		System.out.println();
		map=(Map)JSON.parse(map.get("data").toString());  
		return "haha";
	}
}
