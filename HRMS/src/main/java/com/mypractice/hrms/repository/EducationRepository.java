/**
 * nasru
 * EducationRepository.java
 * Dec 30, 2019
 */
package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypractice.hrms.model.Education;
import com.mypractice.hrms.model.User;

/**
 * @author nasru
 *
 */
public interface EducationRepository extends JpaRepository<Education, Integer> {

	/**
	 * @param user
	 */
	List<Education> findByuser(User user);

	

}
