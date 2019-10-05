package com.mypractice.hrms.service;

import java.util.List;
import java.util.Optional;

import com.mypractice.hrms.model.CityMaster;

public interface CityService {
	CityMaster save(CityMaster cityMaster);
	List<CityMaster> findAll();
	Optional<CityMaster> findOne(Integer cityID);
	void deleteCity(CityMaster cityMst);
	List<CityMaster> getCityDetails();
}
