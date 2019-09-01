 /**
 * 
 */
 package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.User;

/**
 * @author Nasruddin Khan 
 * 30-Aug-2019 - 1:33:30 am
 * UserRepository.java
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * @param email
	 * @return
	 */
	@Query("from User where email = :EMAIL")
	User findUserByEmailID(@Param("EMAIL")String email);

}

 
