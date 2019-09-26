 /**
 * 
 */
 package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.SubMenus;
import com.mypractice.hrms.model.UserRole;
import com.mypractice.hrms.service.SubMenuDetails;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 11:24:02 pm
 * SubMenuRepo.java
 */
@Repository
public interface SubMenuRepo extends JpaRepository<SubMenus, String> {
	@Query("select s.subMenuId as subMenuId, s.subMenuName as subMenuName, m.menuName as menuName, "
			+ " s.createdBy as createdBy, s.createdDate  as createdDate, u.roleName as roleName "
			+ " from SubMenus s "
			+ "left join Menus m on  s.menu = m.menuID "
			+" left join UserRole u on  s.useRole = u.roleID")
	List<SubMenuDetails> getSubMenuDetails();

	/**
	 * @param submenu
	 */
	@Modifying
	@Query("delete from SubMenus where subMenuId = :SUBMENUID")
	Integer deleteSubmenu(@Param("SUBMENUID") String submenu);
	/**
	 * @param roleID
	 * @return
	 */
	@Query("from SubMenus where useRole=:ROLEID")
	List<SubMenus> findAllSubMenu(@Param("ROLEID")UserRole roleID);
	/**
	 * @param suBmenus
	 * @return
	 */
	@Query("from SubMenus where subMenuId In :MENUS")
	List<SubMenus> findAll(@Param("MENUS")List<String> suBmenus);
 
}

 
