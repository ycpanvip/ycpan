package com.wen.security.exception;

public class UserNotExistException extends RuntimeException{
	public UserNotExistException(String id) {
		super("user not exist");
		this.id=id;
	}
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
