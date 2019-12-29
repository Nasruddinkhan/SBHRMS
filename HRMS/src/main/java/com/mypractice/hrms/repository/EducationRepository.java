/**
 * nasru
 * EducationRepository.java
 * Dec 30, 2019
 */
package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypractice.hrms.model.Education;

/**
 * @author nasru
 *
 */
public interface EducationRepository extends JpaRepository<Education, Integer> {

}
