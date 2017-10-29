package com.wen.security.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MockQueue {
	private static final Logger logger = LoggerFactory.getLogger(MockQueue.class);

	private String placeOrder;
	private String complaceOrder;
	public String getPlaceOrder() {
		return placeOrder;
	}
	public void setPlaceOrder(String placeOrder) {
		new Thread(()->{
			logger.info("接到下单请求"+placeOrder);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.complaceOrder = placeOrder;
			logger.info("下单请求处理完成"+placeOrder);
		}).start();
	}
	public String getComplaceOrder() {
		return complaceOrder;
	}
	public void setComplaceOrder(String complaceOrder) {
		this.complaceOrder = complaceOrder;
	}
	
}
