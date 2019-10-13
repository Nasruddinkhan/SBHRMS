package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mypractice.hrms.bean.CityBean;
import com.mypractice.hrms.model.CityMaster;

public interface CityRepository extends JpaRepository<CityMaster, Integer> {
	@Query("Select  new com.mypractice.hrms.bean.CityBean (c.cityID as cityID, c.cityName as cityName, s.stateName as stateName, c.createdBy as cratedBy) from CityMaster  c left join StateMaster s on s.stateID = c.stateMst ")
	List<CityBean> findAllActiveCites();
	
	
	@Modifying
	@Query("Update CityMaster set activeStatus = 0 where cityID =:CITYID")
	Integer deleteCity(@Param("CITYID") Integer cityId);
}
