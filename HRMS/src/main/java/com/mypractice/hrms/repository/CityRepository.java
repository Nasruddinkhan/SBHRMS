package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mypractice.hrms.model.CityMaster;

public interface CityRepository extends JpaRepository<CityMaster, Integer> {

	
	@Query("Select c from CityMaster c where activeStatus = 1")
	List<CityMaster> findAllActiveCites();
	
	@Modifying
	@Query("Update CityMaster set activeStatus = 0 where cityID =:CITYID")
	Integer deleteCity(@Param("CITYID") Integer cityId);
}
