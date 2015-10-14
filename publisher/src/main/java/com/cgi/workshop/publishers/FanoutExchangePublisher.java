package com.cgi.workshop.publishers;

import java.util.stream.IntStream;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class FanoutExchangePublisher extends Publisher{
	final static int NUMBER_OF_QUEUES = 3;
	
	@Override
	protected void send(Object payload) {
		setUp(payload);
		
		messagingTemplate.setExchange(getExchangeName(payload));
		messagingTemplate.convertAndSend(
				payload,
				message -> {
        			logger.info("Sending payload: " + new String(message.getBody()));
        			return message; 
        		}
			);
	}

	private void setUp(Object payload) {
		FanoutExchange exchange = new FanoutExchange(getExchangeName(payload));
		amqpAdmin.declareExchange(exchange);
		
		IntStream.range(0, NUMBER_OF_QUEUES).forEach((i) -> {
			Queue queue = new Queue(getExchangeName(payload) + "_" + i, true);
			Binding binding = BindingBuilder.bind(queue).to(exchange);
			
			amqpAdmin.declareQueue(queue);
			amqpAdmin.declareBinding(binding);
		});
	}

	private String getExchangeName(Object payload){
		return payload.getClass().getSimpleName().toLowerCase() + "_fanout";
	}

}
