 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.hrms.model.UserRole;
import com.mypractice.hrms.repository.UserRoleRepo;
import com.mypractice.hrms.service.UserRoleService;

/**
 * @author Nasruddin Khan 
 * 25-Aug-2019 - 12:17:47 am
 * UserRoleServiceImpl.java
 */
@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
@Autowired
private UserRoleRepo userRoleRepo;
	
	@Override
	public UserRole saveUserRole(UserRole role) {
		// TODO Auto-generated method stub
		return userRoleRepo.save(role);
	}

	@Override
	public Optional<UserRole> findOne(Integer roleID) {
		// TODO Auto-generated method stub
		return userRoleRepo.findById(roleID);
	}

	@Override
	public void deleteRole(UserRole userRole) {
		// TODO Auto-generated method stub
		userRoleRepo.delete(userRole);
	}

	@Override
	public List<UserRole> findAll() {
		// TODO Auto-generated method stub
		return userRoleRepo.findAll();
	}
	

}

 
