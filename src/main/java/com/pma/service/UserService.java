package com.pma.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pma.dao.UserRepo;
import com.pma.entity.UserEntity;
import com.pma.model.User;

@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepo userRepo;

	public void save(User user) throws Exception {
		logger.debug("Inside save...");
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		try {
			userRepo.save(userEntity);
			logger.debug("saved successfully.");
		} catch (Exception ex) {
			throw new Exception("Exception saving user object " + ex.getMessage());
		}
	}

	public List<User> getAllUsers() throws Exception {
		logger.debug("Inside getAllUsers..");
		List<User> targets = new ArrayList<>();
		Iterable<UserEntity> usrs = userRepo.findAll();
		if (usrs != null) {
			for (UserEntity entity : usrs) {
				User target = new User();
				BeanUtils.copyProperties(entity, target);
				targets.add(target);
			}
		}
		return targets;
	}

	public User findByEmpId(String empId) throws Exception {
		logger.debug("Inside findByEmpId..");
		User target = new User();
		UserEntity entity = userRepo.findByEmployeeId(empId);
		BeanUtils.copyProperties(entity, target);
		return target;
	}

	public List<User> findByFirstName(String firstName) throws Exception {
		logger.debug("Inside findByFirstName..");
		List<User> targets = new ArrayList<>();
		Iterable<UserEntity> usrs = userRepo.findByFirstNameContainingIgnoreCase(firstName);
		if (usrs != null) {
			for (UserEntity entity : usrs) {
				User target = new User();
				BeanUtils.copyProperties(entity, target);
				targets.add(target);
			}
		}
		return targets;
	}

	public List<User> findByLastName(String lastName) throws Exception {
		logger.debug("Inside findByLastName..");
		List<User> targets = new ArrayList<>();
		Iterable<UserEntity> usrs = userRepo.findByLastNameContainingIgnoreCase(lastName);
		if (usrs != null) {
			for (UserEntity entity : usrs) {
				User target = new User();
				BeanUtils.copyProperties(entity, target);
				targets.add(target);
			}
		}
		return targets;
	}

	/*public void updateUser(User user) throws Exception{
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		userRepo.save(entity);
	}*/

	public void deleteUser(String empId) throws Exception{
		userRepo.delete(userRepo.findByEmployeeId(empId));
	}
}
