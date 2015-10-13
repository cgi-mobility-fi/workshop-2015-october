package com.cgi.workshop;

import java.util.Random;

public class WorkOrderFactory {
	public static WorkOrder create(){
		WorkOrder workOrder = new WorkOrder();
		workOrder.setId(new Random().nextLong());
		workOrder.setName("Test name");
		
		return workOrder;
	}
}
