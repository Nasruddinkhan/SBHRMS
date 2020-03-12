/**
 * nasru
 * InOutTimeRepo.java
 * Feb 8, 2020
 */
package com.mypractice.hrms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.InOutTime;
import com.mypractice.hrms.model.User;

/**
 * @author nasru
 *
 */
@Repository
public interface InOutTimeRepo extends JpaRepository<InOutTime, Integer>{
	/**
	 * @param details
	 * @param now
	 */
	@Query("from InOutTime where user=:USER and DATE_FORMAT(inTime,'%Y-%m-%d') = :INTIME")
	public InOutTime finByInOutTime(@Param("USER")User details,@Param("INTIME") String localDate);

	/**
	 * @param user
	 * @param secondPageWithFiveElements 
	 * @return
	 */
	public Page<InOutTime> findAllByuser(User user, Pageable firstPageWithTwoElements);
	
}
