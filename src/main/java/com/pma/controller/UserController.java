package com.pma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pma.model.User;
import com.pma.service.UserService;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/users")
	public void addUser(@RequestBody User user) throws Exception {
		logger.debug("Inside Add user");
		userService.save(user);
	}

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers() throws Exception {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping(value = "/users/first-name/{name}")
	public ResponseEntity<List<User>> getuserByFirstName(@PathVariable String name) throws Exception {
		return new ResponseEntity<List<User>>(userService.findByFirstName(name), HttpStatus.OK);
	}

	@GetMapping(value = "/users/last-name/{name}")
	public ResponseEntity<List<User>> getuserByLastName(@PathVariable String name) throws Exception {
		return new ResponseEntity<List<User>>(userService.findByLastName(name), HttpStatus.OK);
	}

	@GetMapping(value = "/users/employeeId/{empId}")
	public ResponseEntity<User> getuserByEmployeeID(@PathVariable String empId) throws Exception {
		return new ResponseEntity<>(userService.findByEmpId(empId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/users/employeeId/{empId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String empId) throws Exception {
		userService.deleteUser(empId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/users/employeeId/{empId}")
	public ResponseEntity<Void> updateUser(@RequestBody User user) throws Exception {
		userService.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
