package com.example.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.TaskDetails;

@Service
public class ToDoTaskImpl {
	
	List<TaskDetails> toDoTaskList = new ArrayList<>();
	
	public void createToDoTask(TaskDetails taskDetails) {
		toDoTaskList.add(taskDetails);
	}
	
	public List<TaskDetails> getAllTasks(String type) {
		List<TaskDetails> list = new ArrayList<>();
		toDoTaskList.forEach(task -> {
			if(task.getStatus().equalsIgnoreCase(type)) {
				list.add(task);
			}
		});
		return list;
	}
	
	public void markTaskAsComplete(int id) {
		toDoTaskList.forEach(task -> {
			if(task.getId() == id) {
				task.setStatus("complete");
			}
		});
	}
	
	public void deleteTask(int id) {
		toDoTaskList.forEach(task -> {
			if(task.getId() == id) {
				toDoTaskList.remove(task);
			}
		});
	}

}
