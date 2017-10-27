package com.wen.security.util;
import java.io.ByteArrayOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;   
public class MyXMLReader2DOM {     
public static String  StringInXml(String array,String  field,String StringParam,String path) {
	try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
	    DocumentBuilder builder = factory.newDocumentBuilder();   
	    Document doc = builder.parse(ResourceUtils.getFile(path));   
	    NodeList nl = doc.getElementsByTagName("filter");   
	    for (int i = 0; i < nl.getLength(); i++) {
	    	doc.getElementsByTagName("filter").item(i).setTextContent(StringParam);  
	    }
	    nl = doc.getElementsByTagName("groupBy");   
	    for (int i = 0; i < nl.getLength(); i++) {
	    	doc.getElementsByTagName("groupBy").item(i).setTextContent(array);  
	    }
	    nl = doc.getElementsByTagName("field");   
	    for (int i = 0; i < nl.getLength(); i++) {
	    	if(i == nl.getLength()-1) {
	    		 doc.getElementsByTagName("field").item(i).getChildNodes().item(1).   setTextContent(field);		    		
	    	}
	    }
	    return xmlToString(doc).replaceAll("&amp;", "&");//formatXml(doc,"utf-8",false);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "";
}

public static String xmlToString( Document doc) {
	TransformerFactory   tf   =   TransformerFactory.newInstance();
	Transformer t;
	try {
		t = tf.newTransformer();
		t.setOutputProperty("encoding","UTF-8");//解决中文问题，试过用GBK不行
		ByteArrayOutputStream   bos   =   new   ByteArrayOutputStream();
		t.transform(new DOMSource(doc), new StreamResult(bos));
		String xmlStr = bos.toString();
		return xmlStr;
	} catch (Exception e) {
		e.printStackTrace();
		return "";
	}
	
   }
}