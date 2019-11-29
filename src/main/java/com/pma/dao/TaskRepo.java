package com.pma.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pma.entity.TaskEntity;

@Repository
public interface TaskRepo extends CrudRepository<TaskEntity, Long> {

}
