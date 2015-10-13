package com.cgi.workshop;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PayloadLogger {
	private final Logger logger = Logger.getLogger(getClass());

	@RabbitListener(queues = { Settings.WORKORDERS_CHANNEL })
	void onMessageReceived(Message message) {
		logger.info("Received payload: " + new String(message.getBody()));
		logger.info("Received properties: " + message.getMessageProperties());
	}
}
