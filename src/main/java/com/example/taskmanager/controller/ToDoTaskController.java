package com.example.taskmanager.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.model.Result;
import com.example.taskmanager.model.TaskDetails;
import com.example.taskmanager.service.ToDoTaskImpl;

@RestController
public class ToDoTaskController {
	
	@Autowired
	private ToDoTaskImpl toDoTaskImpl;
	
	@PostMapping("/createToDoTask")
	public ResponseEntity<?> createToDoTask(@RequestBody TaskDetails taskDetails) {
		toDoTaskImpl.createToDoTask(taskDetails);
		return ResponseEntity.ok(new Result("SUCCESS"));
	}
	
	@GetMapping("/getTasks/{typeOfList}")
	public List<TaskDetails> getAllTasks(@PathParam("typeOfList") String typeOfList) {
		
		return toDoTaskImpl.getAllTasks(typeOfList);
	}
	
	@PatchMapping("/completeTask/{{id}}")
	public ResponseEntity<?> markTaskAsComplete(@RequestParam("id") int id) {
		toDoTaskImpl.markTaskAsComplete(id);
		return ResponseEntity.ok(new Result("SUCCESS"));
		
	}
	
	@DeleteMapping("/deleteTask/{{id}}")
	public ResponseEntity<?> deleteTask(@RequestParam("id") int id) {
		toDoTaskImpl.deleteTask(id);
		return ResponseEntity.ok(new Result("SUCCESS"));
	}

}
