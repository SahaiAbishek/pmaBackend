package com.pma.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pma.dao.ProjectRepo;
import com.pma.entity.ProjectEntity;
import com.pma.model.Project;

@Service
public class ProjectService {

	Logger logger = LoggerFactory.getLogger(ProjectService.class);

	@Autowired
	private ProjectRepo projRepo;

	public void save(Project project) throws Exception {
		logger.debug("Inside save...");
		ProjectEntity projectEntity = new ProjectEntity();
		BeanUtils.copyProperties(project, projectEntity);
		try {
			projRepo.save(projectEntity);
			logger.debug("saved successfully.");
		} catch (Exception ex) {
			throw new Exception("Exception saving user object " + ex.getMessage());
		}
	}

	public List<Project> getAllProjects() throws Exception {
		logger.debug("Inside getAllProjects..");
		List<Project> targets = new ArrayList<>();
		Iterable<ProjectEntity> projects = projRepo.findAll();
		if (projects != null) {
			for (ProjectEntity project : projects) {
				Project target = new Project();
				BeanUtils.copyProperties(project, target);
				targets.add(target);
			}
		}
		return targets;
	}

}
