package com.wen.security.dto;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent>{
	private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);

	@Autowired
	private MockQueue moQueue;
	@Autowired
	private DeferredResultHalder deferredResultHalder;
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//无限循环
		new Thread(()->{
			while(true) {
				if(StringUtils.isNoneBlank(moQueue.getComplaceOrder())) {
					String orderNumber=moQueue.getComplaceOrder();
					logger.info("返回订单处理结果"+orderNumber);
					deferredResultHalder.getMap().get(orderNumber).setResult("place order success");
					moQueue.setComplaceOrder(null);
				}else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
			}
		}).start();
	}
	
}
