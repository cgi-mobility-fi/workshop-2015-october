package com.cgi.workshop.publishers;

import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.workshop.Settings;

@Component
public abstract class Publisher {
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	AmqpAdmin amqpAdmin;
	@Autowired
	RabbitTemplate messagingTemplate;
	
	public void publish(Supplier<Object> payloadFunction) throws InterruptedException {
		messagingTemplate.setMessageConverter(new JsonMessageConverter());
		
		while(true){
			send(payloadFunction.get());
			Thread.sleep(Settings.PUBLISH_INTERVAL);
		}
	}

	protected abstract void send(Object payload);
}
