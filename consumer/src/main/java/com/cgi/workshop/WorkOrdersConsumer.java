package com.cgi.workshop;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class WorkOrdersConsumer {
	private final Logger logger = Logger.getLogger(getClass());

	@RabbitListener(queues = { "workorder_direct" }, containerFactory = "rabbitListenerContainerFactory")
	void onWorkOrderReceived(Message<WorkOrder> workOrder){
		logger.info("Received workOrder: " + workOrder);
	}
}
