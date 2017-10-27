package com.wen.security.util;
import java.util.List;
public class BeanResult {
	private List<String> list;
	private String orderByString;
	private String stringParam;
	private String stringField;
	private String path;
	private String xmlString;
	private byte[] byteString;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getXmlString() {
		return xmlString;
	}
	public void setXmlString(String xmlString) {
		this.xmlString = xmlString;
	}
	public byte[] getByteString() {
		return byteString;
	}
	public void setByteString(byte[] byteString) {
		this.byteString = byteString;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String getStringParam() {
		return stringParam;
	}
	public void setStringParam(String stringParam) {
		this.stringParam = stringParam;
	}
	public String getStringField() {
		return stringField;
	}
	public void setStringField(String stringField) {
		this.stringField = stringField;
	}
	public String getOrderByString() {
		return orderByString;
	}
	public void setOrderByString(String orderByString) {
		this.orderByString = orderByString;
	}
	public BeanResult() {};
	public BeanResult(List<String> list,String orderByString, String stringParam, String stringField) {
		this.list = list;
		this.orderByString=orderByString;
		this.stringParam = stringParam;
		this.stringField = stringField;
	}
}
