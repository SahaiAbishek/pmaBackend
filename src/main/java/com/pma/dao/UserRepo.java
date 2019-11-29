package com.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pma.entity.UserEntity;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
	
	public UserEntity findByEmployeeId(String employeeId);

	public List<UserEntity> findByFirstNameContainingIgnoreCase(String firstName);

	public List<UserEntity> findByLastNameContainingIgnoreCase(String lastName);

}
