package com.mypractice.hrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.hrms.bean.CityBean;
import com.mypractice.hrms.model.CityMaster;
import com.mypractice.hrms.repository.CityRepository;
import com.mypractice.hrms.service.CityService;

@Transactional
@Service("cityService")
public class CityServiceImpl implements CityService 
{
	@Autowired
	private CityRepository cityRepository;

	@Override
	public CityMaster save(CityMaster cityMaster) {
		// TODO Auto-generated method stub
		return cityRepository.save(cityMaster);
	}

	@Override
	public List<CityMaster> findAll() {
		// TODO Auto-generated method stub
		return cityRepository.findAll();
	}

	@Override
	public Optional<CityMaster> findOne(Integer cityID) {
		// TODO Auto-generated method stub
		return cityRepository.findById(cityID);
	}

	@Override
	public void deleteCity(CityMaster cityMst) {
		// TODO Auto-generated method stub
		cityRepository.delete(cityMst);
	}

	@Override
	public List<CityBean> getCityDetails() {
		// TODO Auto-generated method stub
		return cityRepository.findAllActiveCites();
	}

}
