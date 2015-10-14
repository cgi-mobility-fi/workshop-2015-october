package com.cgi.workshop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class WorkOrder {
	private Long id;
	private String name;
	private String externalId;
	private Date plannedStartTime;
	private Set<Event> events = new HashSet<Event>();
	private Employee assignee;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "WorkOrder{" + "id='" + id + '\'' + ", name=" + name + '}';
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public Date getPlannedStartTime() {
		return plannedStartTime;
	}
	public void setPlannedStartTime(Date plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}
	public Employee getAssignee() {
		return assignee;
	}
	public void setAssignee(Employee assignee) {
		this.assignee = assignee;
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
}
