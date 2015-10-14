package com.cgi.workshop;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class WorkOrderFactory {
	public static WorkOrder create(){
		WorkOrder workOrder = new WorkOrder();
		workOrder.setId(new Random().nextLong());
		workOrder.setName("Test name");
		workOrder.setExternalId("External");
		workOrder.setPlannedStartTime(new Date());
		workOrder.setAssignee(new Employee(){
			{
				setId(1L);
				setUsername("siimtoomas");
			}
		});
		workOrder.setEvents(new HashSet<Event>(){
			{
				add(new Event(){
					{
						setId(100L);
						setTimestamp(new Date());
					}
				});
				add(new Event(){
					{
						setId(200L);
						setTimestamp(new Date());
					}
				});
			}
		});
		
		return workOrder;
	}
}
