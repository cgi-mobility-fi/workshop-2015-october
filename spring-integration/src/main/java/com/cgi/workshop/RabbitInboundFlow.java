package com.cgi.workshop;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.amqp.Amqp;
import org.springframework.integration.dsl.support.Transformers;

@Configuration
public class RabbitInboundFlow {
	final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
    private RabbitConfig rabbitConfig;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(this.connectionFactory);
        listenerContainer.setQueues(this.rabbitConfig.sampleQueue());
        //listenerContainer.setConcurrentConsumers(1);
        //listenerContainer.setExclusive(true);
        return listenerContainer;
    }
    // https://github.com/spring-projects/spring-integration-java-dsl/blob/master/src/test/java/org/springframework/integration/dsl/test/amqp/AmqpTests.java
    @Bean
    public IntegrationFlow inboundFlow(ConnectionFactory rabbitConnectionFactory) {
        return IntegrationFlows
        		.from(Amqp.inboundAdapter(simpleMessageListenerContainer()))
                .transform(Transformers.objectToString())
                .handle((m) -> {
                    logger.info("Processed  " + m.getPayload());
                })
                .get();
    }
}
