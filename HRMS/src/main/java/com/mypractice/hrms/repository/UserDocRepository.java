/**
 * nasru
 * UserDocRepository.java
 * Jan 12, 2020
 */
package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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

}
