package com.wen.security.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements  HandlerInterceptor{

	//页面渲染完毕之后执行
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object hander, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TimeInterceptor finish");
	}

	//方法之后
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object hander, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");
		long startTime=(long)request.getAttribute("startTime");
		System.out.println("TimeInterceptor 耗时"+(new Date().getTime()-startTime));
		

	}

	//方法之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hander) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle");
		System.out.println(((HandlerMethod)hander).getBean().getClass().getName());
		System.out.println(((HandlerMethod)hander).getMethod().getName());
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}
}
