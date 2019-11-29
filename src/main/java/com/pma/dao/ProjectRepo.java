package com.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pma.entity.ProjectEntity;

@Repository
public interface ProjectRepo extends CrudRepository<ProjectEntity, Long> {

	public List<ProjectEntity> findByProjectContainingIgnoreCase(String project);

}
