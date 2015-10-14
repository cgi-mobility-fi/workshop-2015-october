package com.cgi.workshop;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class WorkOrdersConsumer {
	private final Logger logger = Logger.getLogger(getClass());

	@RabbitListener(queues = { Settings.WORKORDERS_CHANNEL }, containerFactory = "rabbitListenerContainerFactory")
	void onWorkOrderReceived(Message<WorkOrder> workOrder){
		logger.info("Received workOrder: " + workOrder);
	}
	
	@RabbitListener(queues = { "workorder_request_reply" })
	public String onReceived(Message<WorkOrder> workOrder) {
		logger.info("Received req");
		return "Received: ";
	}
}
