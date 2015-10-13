package com.cgi.workshop;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	AmqpAdmin amqpAdmin;
	@Autowired
	RabbitTemplate messagingTemplate;
	
	public void publish() throws InterruptedException {
		setUp();
		while(true){
			WorkOrder wo = WorkOrderFactory.create();
			messagingTemplate.convertAndSend(
				Settings.WORKORDERS_CHANNEL, 
				wo,
				message -> {
        			logger.info("Sending payload: " + new String(message.getBody()));
        			return message; 
        		}
			);
			
			Thread.sleep(1000);
		}
	}
	
	private void setUp(){
		Queue queue = new Queue(Settings.WORKORDERS_CHANNEL, true);
		DirectExchange exchange = new DirectExchange(Settings.WORKORDERS_CHANNEL);
		Binding binding = BindingBuilder.bind(queue).to(exchange).with(Settings.WORKORDERS_CHANNEL);
		amqpAdmin.declareQueue(queue);
		amqpAdmin.declareExchange(exchange);
		amqpAdmin.declareBinding(binding);
		
		messagingTemplate.setMessageConverter(new JsonMessageConverter());
	}

}
