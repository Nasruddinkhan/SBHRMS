/**
 * nasru
 * WorkStatausRepo.java
 * Mar 10, 2020
 */
package com.mypractice.hrms.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.User;
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
	//@Query("from WorkStataus where endTime between :STARTTIME AND  :ENDTIME ")
	//List<WorkStataus> findByendTime(@Param("STARTTIME")Timestamp startTime, @Param("ENDTIME")Timestamp endTime);

	/**
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@Query("from WorkStataus where startTime <= :ENDTIME   AND  endTime>= :STARTTIME")
	List<WorkStataus> findBystartTime(@Param("STARTTIME")Timestamp startTime, @Param("ENDTIME")Timestamp endTime);

	/**
	 * @param user
	 * @param firstPageWithTwoElements 
	 * @return
	 */
	//@Query("Select  new com.mypractice.hrms.bean.WorkStatusBean(w.workStatusID, w.workDate, w.startTime,  w.endTime, w.remark )  from WorkStataus w where w.user =:USER")
	//@Query("Select  new com.mypractice.hrms.bean.CityBean (c.cityID as cityID, c.cityName as cityName, s.stateName as stateName, c.createdBy as cratedBy) from CityMaster  c left join StateMaster s on s.stateID = c.stateMst ")
	/*@Query("Select  w, s,m from WorkStataus w inner join SkillElementMaster s "
			+ " on s.skillElementID = w.skillElementMst  "
			+ " inner join SkillMaster m "
			+ " on m.skillID = w.skillMst   where w.user =:USER")*/
	/*@Query(
			  value = "SELECT * FROM WORK_REMARKS  where USER_ID =:USER", 
			  countQuery = "SELECT count(*) FROM WORK_REMARKS  where USER_ID =:USER", 
			  nativeQuery = true)*/
	//Page<WorkStataus> findAllByuser(@Param("USER")Integer user, Pageable firstPageWithTwoElements);
	Page<WorkStataus> findAllByuser(@Param("USER")User user, Pageable firstPageWithTwoElements);
}
