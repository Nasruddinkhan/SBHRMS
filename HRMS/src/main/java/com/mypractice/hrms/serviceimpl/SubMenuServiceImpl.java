 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.hrms.exception.ResourceNotFoundException;
import com.mypractice.hrms.model.SubMenus;
import com.mypractice.hrms.repository.SubMenuRepo;
import com.mypractice.hrms.service.SubMenuDetails;
import com.mypractice.hrms.service.SubMenuService;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 11:23:12 pm
 * SubMenuServiceImpl.java
 */
@Transactional
@Service("subMenuService")
public class SubMenuServiceImpl implements SubMenuService {
@Autowired
private SubMenuRepo subMenuRepo;
	@Override
	public SubMenus save(SubMenus subMenus) {
		// TODO Auto-generated method stub
		return subMenuRepo.save(subMenus);
	}
	@Override
	public List<SubMenuDetails> findAll() {
		// TODO Auto-generated method stub
		return subMenuRepo.getSubMenuDetails();
	}
	@Override
	public SubMenus findOne(String subMenuID) {
		// TODO Auto-generated method stub
		return subMenuRepo.findById(subMenuID).orElseThrow(()->new ResourceNotFoundException(subMenuID+" sub menu id is not found"));
		
	}
	@Override
	public void deleteSubMenu(String submenu) {
		// TODO Auto-generated method stub
		Integer row = subMenuRepo.deleteSubmenu(submenu);
		System.out.println("row ["+row+"]");
	}

}

 
