package com.wen.security.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
@Aspect
@Component
public class TimeAspect {
	@Before("execution(* com.wen.security.controller.UserController.*(..))")
	public void before() {
		System.out.println("before");
	}
	@After("execution(* com.wen.security.controller.UserController.*(..))")
	public void after() {
		System.out.println("after");
	}
	@Around("execution(* com.wen.security.controller.UserController.*(..))")
	public Object handleValidateResult(ProceedingJoinPoint pjp) throws Throwable {				
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			if(arg instanceof BindingResult) {
				BindingResult errors = (BindingResult)arg;
				if (errors.hasErrors()) {
					//throw new ValidateException(errors.getAllErrors());
				}
			}
		}
		Object result = pjp.proceed();
		return result;
	}
}
