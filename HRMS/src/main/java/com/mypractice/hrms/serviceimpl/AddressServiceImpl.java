/**
 * nasru
 * AddressServiceImpl.java
 * Dec 28, 2019
 */
package com.mypractice.hrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.hrms.model.Addresses;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.AddressDetails;
import com.mypractice.hrms.repository.AddressRepository;
import com.mypractice.hrms.service.AddressService;

/**
 * @author nasru
 *
 */
@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {
@Autowired
private AddressRepository addressRepository;
	@Override
	public Addresses saveAddress(Addresses address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}
	@Override
	public List<Addresses> findAll() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}
	@Override
	public Optional<Addresses> findOne(Integer addressID) {
		// TODO Auto-generated method stub
		return addressRepository.findById(addressID);
	}
	@Override
	public AddressDetails getUserAddress(User userID) {
		return addressRepository.getUserDetails(userID);
	}

}
