package com.cgi.workshop.publishers;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RequestReplyPublisher extends Publisher {

	@Override
	protected void send(Object payload) {
		String routingKey = getExchangeName(payload);
		setUp(routingKey);

		logger.info("start sending and receiving");
		messagingTemplate.setQueue(routingKey);
		messagingTemplate.setReplyTimeout(60 * 1000);
		Object result = messagingTemplate.convertSendAndReceive(
				routingKey, 
				payload, 
				message -> {
					logger.info("Sending payload: " + new String(message.getBody()));
					return message;
				}
		);
		logger.info("Received result: " + result);
	}

	private void setUp(String name) {
		Queue queue = new Queue(name, true);
		DirectExchange exchange = new DirectExchange(name);
		Binding binding = BindingBuilder.bind(queue).to(exchange).with(name);
		amqpAdmin.declareQueue(queue);
		amqpAdmin.declareExchange(exchange);
		amqpAdmin.declareBinding(binding);
	}

	private String getExchangeName(Object payload) {
		return payload.getClass().getSimpleName().toLowerCase() + "_request_reply";
	}

}
