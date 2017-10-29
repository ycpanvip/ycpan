package com.wen.security.controller;

import java.util.concurrent.Callable;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.wen.security.dto.DeferredResultHalder;
import com.wen.security.dto.MockQueue;

@RestController
@RequestMapping("/async")
public class AsyncController {
	private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);
	@Autowired
	private MockQueue moQueue;
	@Autowired
	private DeferredResultHalder deferredResultHalder;
	@GetMapping
	public String asyncSuccess() {
		logger.info("主线程开始");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("主线程结束");
		return "success";
	}
	@GetMapping("/deferredReult")
	public DeferredResult<String> asyncSuccessDeferredReult () {
		logger.info("主线程开始");
		String orderNumber=RandomStringUtils.randomNumeric(8);
		moQueue.setPlaceOrder(orderNumber);
		DeferredResult<String> result=new DeferredResult<String>();
		deferredResultHalder.getMap().put(orderNumber, result);
		logger.info("主线程结束");
			return result;
	}
	
	@GetMapping("/runnable")
	public Callable<String> asyncSuccessRunnable() {
		logger.info("主线程开始");
		Callable<String> result=new Callable<String>(){
			public String call() throws Exception {
				logger.info("副线程开始");
				Thread.sleep(1000);
				logger.info("副线程结束");
				// TODO Auto-generated method stub
				return null;
			}
			
		} ;
		logger.info("主线程结束");
		return result;
	}
}
