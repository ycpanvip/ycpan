package com.wen.security.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object>{
	//注解加载的方法
	public void initialize(MyConstraint arg0) {
		System.out.println("MyConstraint int");
		// TODO Auto-generated method stub
	}
	@Override
	//验证方法
	public boolean isValid(Object value, ConstraintValidatorContext content) {
		// TODO Auto-generated method stub
		System.out.println(value);
		return false;
	}
	
}
