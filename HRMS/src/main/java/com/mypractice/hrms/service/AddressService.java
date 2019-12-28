/**
 * nasru
 * AddressService.java
 * Dec 28, 2019
 */
package com.mypractice.hrms.service;

import java.util.List;
import java.util.Optional;

import com.mypractice.hrms.model.Addresses;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.AddressDetails;

/**
 * @author nasru
 *
 */
public interface AddressService {
	Addresses saveAddress(Addresses address);

	/**
	 * @return
	 */
	List<Addresses> findAll();

	/**
	 * @param addressID
	 * @return
	 */
	Optional<Addresses> findOne(Integer addressID);

	/**
	 * @param user
	 */
	AddressDetails getUserAddress(User user);
}
