package com.cgi.workshop.publishers;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.stereotype.Component;

@Component
public class TopicExchangePublisher extends Publisher{

	@Override
	protected void send(Object payload) {
		String routingKey = getExchangeName(payload);
		
		setUp(routingKey);

		messagingTemplate.convertAndSend(
				routingKey,
				payload,
				message -> {
        			logger.info("Sending payload: " + new String(message.getBody()));
        			return message; 
        		}
			);
	}

	private void setUp(String name) {
		Queue queue = new Queue(name, true);
		TopicExchange exchange = new TopicExchange(name);
		// "*.name.*"/ "*.*.name" / "name.#"
		Binding binding = BindingBuilder.bind(queue).to(exchange).with(name + "*.*");
		amqpAdmin.declareQueue(queue);
		amqpAdmin.declareExchange(exchange);
		amqpAdmin.declareBinding(binding);
	}

	private String getExchangeName(Object payload){
		return payload.getClass().getSimpleName().toLowerCase() + "_test";
	}

}
