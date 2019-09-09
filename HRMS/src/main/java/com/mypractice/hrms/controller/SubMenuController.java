/**
* 
*/
package com.mypractice.hrms.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mypractice.hrms.exception.ResourceNotFoundException;
import com.mypractice.hrms.model.Menus;
import com.mypractice.hrms.model.SubMenus;
import com.mypractice.hrms.service.MenuService;
import com.mypractice.hrms.service.SubMenuService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Nasruddin Khan 09-Sep-2019 - 10:27:51 pm SubMenuController.java
 */
@RestController
@RequestMapping("/hrms/api/")
public final class SubMenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private SubMenuService subMenuService;
	@ApiOperation(value = "add new sub menu manster.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("/submenu/{menuID}/savesubmenus")
	public ResponseEntity<?> saveSubMenu( @RequestBody SubMenus subMenus, @PathVariable("menuID") Integer menuID) {
		Optional<Menus> menus = menuService.findOne(menuID);
		if(!menus.isPresent())
			throw new ResourceNotFoundException("menu is not found ="+menuID);
		subMenus.setMenu(menus.get());
		SubMenus sub = subMenuService.save(subMenus);
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{subMenuId}")
				.buildAndExpand(sub.getSubMenuId()).toUri();
		return ResponseEntity.created(uriLocation).build();
	}
	@ApiOperation(value = "add new sub menu manster.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/submenu/submenus")
	public List<SubMenus> findAll(){
		return subMenuService.findAll();
	}
}