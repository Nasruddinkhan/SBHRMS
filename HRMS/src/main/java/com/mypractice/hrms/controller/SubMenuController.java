/**
* 
*/
package com.mypractice.hrms.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.mypractice.hrms.model.UserRole;
import com.mypractice.hrms.repository.MenuRepo;
import com.mypractice.hrms.repository.SubMenuRepo;
import com.mypractice.hrms.repository.UserRoleRepo;
import com.mypractice.hrms.service.SubMenuDetails;

import io.swagger.annotations.ApiOperation;

/**
 * @author Nasruddin Khan 09-Sep-2019 - 10:27:51 pm SubMenuController.java
 */
@RestController
@RequestMapping("/hrms/api/")
public class SubMenuController {
	@Autowired
	private MenuRepo menuRepo;
	@Autowired
	private SubMenuRepo subMenuRepo;
	@Autowired
	private UserRoleRepo userRoleRepo;

	@ApiOperation(value = "add new sub menu manster.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("/submenu/{menuID}/{roleID}/savesubmenus")
	public ResponseEntity<?> saveSubMenu(@RequestBody SubMenus subMenus, @PathVariable("menuID") Integer menuID,
			@PathVariable Integer roleID) {
		Optional<Menus> menus = menuRepo.findById(menuID);
		if (!menus.isPresent())
			throw new ResourceNotFoundException("menu is not found =" + menuID);
		Optional<UserRole> userRole = userRoleRepo.findById(roleID);
		if (!userRole.isPresent())
			throw new ResourceNotFoundException("roleID is not found =" + roleID);
		subMenus.setMenu(menus.get());
		subMenus.setUseRole(userRole.get());
		SubMenus sub = subMenuRepo.save(subMenus);
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{subMenuId}")
				.buildAndExpand(sub.getSubMenuId()).toUri();
		return ResponseEntity.created(uriLocation).build();
	}

	@ApiOperation(value = "add new sub menu manster.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/submenu/submenus")
	public List<SubMenuDetails> findAll() {
		return subMenuRepo.getSubMenuDetails();
	}

	@ApiOperation(value = "add new sub menu manster.", notes = "Returns the  ResponseMessage  in body.")
	@DeleteMapping("/submenu/{subMenuId}/delete")
	public void deleteSubMenu(@PathVariable String subMenuId) {
		String submenID = subMenuId.replaceAll("-", "/");
		subMenuRepo.deleteSubmenu(submenID);
	}
}
