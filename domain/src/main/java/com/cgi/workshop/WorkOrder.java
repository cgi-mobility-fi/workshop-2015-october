package com.cgi.workshop;

public class WorkOrder {
	private Long id;
	private String name;
	
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
}
