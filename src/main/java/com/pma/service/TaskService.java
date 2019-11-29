package com.pma.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pma.dao.TaskRepo;
import com.pma.entity.TaskEntity;
import com.pma.model.Task;

@Service
public class TaskService {

	Logger logger = LoggerFactory.getLogger(TaskService.class);

	@Autowired
	private TaskRepo taskRepo;

	public void save(Task task) throws Exception {
		logger.debug("Inside save...");
		TaskEntity taskEntity = new TaskEntity();
		BeanUtils.copyProperties(task, taskEntity);
		try {
			taskRepo.save(taskEntity);
			logger.debug("saved successfully.");
		} catch (Exception ex) {
			throw new Exception("Exception saving user object " + ex.getMessage());
		}
	}

	public List<Task> getAllTasks() throws Exception {
		logger.debug("Inside getAllTasks..");
		List<Task> targets = new ArrayList<>();
		Iterable<TaskEntity> tasks = taskRepo.findAll();
		if (tasks != null) {
			for (TaskEntity task : tasks) {
				Task target = new Task();
				BeanUtils.copyProperties(task, target);
				targets.add(target);
			}
		}
		return targets;
	}

}
