package com.wen.security.exception;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ControllerException {
	@ExceptionHandler(UserNotExistException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public  Map<String,String> handleUserNotExistException(UserNotExistException ex){
		 Map<String,String> map=new HashMap<String,String>();
		 map.put("id", ex.getId());
		 map.put("message", ex.getMessage());
		 return map;
	}
}
