/**
 * nasru
 * WorkStatausRepo.java
 * Mar 10, 2020
 */
package com.mypractice.hrms.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.WorkStataus;

/**
 * @author nasru
 *
 */
@Repository
public interface WorkStatausRepo extends JpaRepository<WorkStataus, Integer> {

	/**
	 * @param startTime
	 * @param endTime
	 */
	@Query("from WorkStataus where endTime between :STARTTIME AND  :ENDTIME ")
	List<WorkStataus> findByendTime(@Param("STARTTIME")Timestamp startTime, @Param("ENDTIME")Timestamp endTime);

	/**
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@Query("from WorkStataus where startTime between :STARTTIME AND  :ENDTIME ")
	List<WorkStataus> findBystartTime(@Param("STARTTIME")Timestamp startTime, @Param("ENDTIME")Timestamp endTime);

}
