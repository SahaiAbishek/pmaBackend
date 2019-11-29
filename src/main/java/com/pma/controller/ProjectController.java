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

import com.pma.model.Project;
import com.pma.service.ProjectService;

@RestController
public class ProjectController {

	Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectService projService;

	@PostMapping(value = "/projects")
	public void addProject(@RequestBody Project project) throws Exception {
		logger.debug("Inside addProject...");
		projService.save(project);
	}

	@GetMapping(value = "/projects")
	public ResponseEntity<List<Project>> getAllProjects() throws Exception {
		logger.debug("Inside getAllProjects...");
		return new ResponseEntity<>(projService.getAllProjects(), HttpStatus.OK);
	}
}
