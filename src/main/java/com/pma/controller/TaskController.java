package com.pma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pma.model.Task;
import com.pma.service.TaskService;

@RestController
public class TaskController {
	
	Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	TaskService taskService;

	@PostMapping(value = "/tasks")
	public void addTask(@RequestBody Task task) throws Exception {
		logger.debug("Inside addTask...");
		taskService.save(task);
	}

	@GetMapping(value = "/tasks")
	public ResponseEntity<List<Task>> getAllTasks() throws Exception {
		logger.debug("Inside getAllTasks...");
		return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
	}
	
}
