/**
 * nasru
 * UserDocRepository.java
 * Jan 12, 2020
 */
package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mypractice.hrms.model.DocumentMaster;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.model.UserDocument;

/**
 * @author nasru
 *
 */
public interface UserDocRepository extends JpaRepository<UserDocument, Integer> {

	/**
	 * @param user
	 * @return
	 */
	List<UserDocument> findByuser(User user);
	/**
	 * @param user
	 * @param docMaster
	 */
	@Query("select docuentName from UserDocument where  user = :USER and  usrDocuments =:DOCMASTER")
	String findByuserandusrDocuments(@Param("USER")User user,@Param("DOCMASTER") DocumentMaster docMaster);

}
