/**
 * nasru
 * CourseRepository.java
 * Dec 29, 2019
 */
package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.Course;

/**
 * @author nasru
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

}
