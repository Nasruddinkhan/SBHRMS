 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.hrms.bean.DropDownBean;
import com.mypractice.hrms.model.SubMenus;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.SubMenuRepo;
import com.mypractice.hrms.repository.UserRepository;
import com.mypractice.hrms.service.HRMSService;

/**
 * @author Nasruddin Khan 
 * 14-Sep-2019 - 2:01:13 pm
 * HRMSServiceImpl.java
 */
@Service("hRMSService")
@Transactional
public class HRMSServiceImpl implements HRMSService {
	@Autowired
	private SubMenuRepo menuRepo;
	@Autowired
	private UserRepository userRepo;

	@Override
	public Map<String, List<DropDownBean>> getDropDowns() {
		Function<User, String> getName =  s ->  null == s.getFirstName() ? s.getEmail(): s.getFirstName();
		// TODO Auto-generated method stub
		Map<String, List<DropDownBean>> map = new HashMap<String, List<DropDownBean>>();
		map.put("menuList", menuRepo.findAll().stream().map((Function<? super SubMenus , DropDownBean> ) obj->{
			DropDownBean drop = new DropDownBean();
			drop.setId(obj.getSubMenuId());
			drop.setCode(obj.getSubMenuName());
			return drop;
		}).collect(Collectors.toList()));
		map.put("userList",userRepo.findAll().stream().map((Function<? super User , DropDownBean> ) obj->{
			DropDownBean drop = new DropDownBean();
			drop.setId(obj.getUserID().toString());
			drop.setCode(getName.apply(obj));
			return drop;
		}).collect(Collectors.toList()));
		return map;
	}

}

 
