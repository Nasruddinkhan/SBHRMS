 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.hrms.bean.ResponseMessage;
import com.mypractice.hrms.model.MenuAccessRole;
import com.mypractice.hrms.model.SubMenus;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.MenuAccessRoleRepo;
import com.mypractice.hrms.repository.SubMenuRepo;
import com.mypractice.hrms.repository.UserRepository;
import com.mypractice.hrms.service.UserService;


/**
 * @author Nasruddin Khan 
 * 30-Aug-2019 - 1:27:18 am
 * UserServiceImpl.java
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MenuAccessRoleRepo menuRepo;
	@Autowired
	private SubMenuRepo subMenuRepo;
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}
	@Override
	public User checkEmail(String email) {
		return userRepo.findUserByEmailID(email);
	}
	
	@Override
	public ResponseMessage genrateRoleAccessMenu(User user) {
		// TODO Auto-generated method stub
		ResponseMessage responseMessage = new ResponseMessage();
		List<SubMenus> subMenus=subMenuRepo.findAllSubMenu(user.getUserRole());
		if(subMenus.isEmpty()) {
			throw new RuntimeException("please asign the menu access on below user");
		}
		List<MenuAccessRole> menUAccessList = new ArrayList<MenuAccessRole>();
		subMenus.forEach(obj->{
			MenuAccessRole meAccessRole = new MenuAccessRole();
			meAccessRole.setActiveStatus(1);
			meAccessRole.setMenu(obj);
			meAccessRole.setUser(user);
			meAccessRole.setComments("Default Access");
			menUAccessList.add(meAccessRole);
		});
		System.out.println(subMenus.size());
		List<MenuAccessRole> menuAccess = menuRepo.saveAll(menUAccessList);
		if(menuAccess != null && menuAccess.size() > 0) {
			responseMessage.setErrorCode(200);
			responseMessage.setErrorMessage("Aproved Successfully");
		}
		return responseMessage;
	}
	@Override
	public Optional<User> findOne(Integer userid) {
		// TODO Auto-generated method stub
		return userRepo.findById(userid);
	}
}

 
