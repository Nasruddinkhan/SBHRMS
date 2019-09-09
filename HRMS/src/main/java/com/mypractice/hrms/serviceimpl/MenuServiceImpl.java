 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.hrms.model.Menus;
import com.mypractice.hrms.repository.MenuRepo;
import com.mypractice.hrms.service.MenuService;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 1:10:11 am
 * MenuServiceImpl.java
 */
@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService {
@Autowired
private MenuRepo menuRepo;
	@Override
	public Menus saveUserRole(Menus menus) {
		// TODO Auto-generated method stub
		return menuRepo.save(menus);
	}
	@Override
	public List<Menus> findAll() {
		// TODO Auto-generated method stub
		return menuRepo.findAll();
	}
	@Override
	public Optional<Menus> findOne(Integer menuID) {
		// TODO Auto-generated method stub
		return menuRepo.findById(menuID);
	}
	@Override
	public void deleteMenu(Menus menus) {
		// TODO Auto-generated method stub
		menuRepo.delete(menus);
	}

}

 
