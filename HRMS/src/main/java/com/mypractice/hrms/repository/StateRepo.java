package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mypractice.hrms.model.StateMaster;

public interface StateRepo extends JpaRepository<StateMaster, Integer> {

	@Query("Select s from StateMaster s where activeStatus = 1")
	List<StateMaster> findAllActiveStates();
	
	@Modifying
	@Query("Update StateMaster set activeStatus = 0 where stateID =:STATEID")
	Integer deleteState(@Param("STATEID") Integer stateId);
	
	@Query("select stateID as ID, stateName as code  from StateMaster")
	List<CommonDropdown> getStates();
}
