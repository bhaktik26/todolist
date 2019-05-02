package com.example.taskmanager.model;

public class TaskDetails {

	private int id;
	private String task;
	private String tag;
	private String status;

	private static int counter = 0;

	public TaskDetails(String task, String tag, String status) {
		this.id = counter++;
		this.task = task;
		this.tag = tag;
		this.status = status;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}
		
}
