/**
 * nasru
 * AddressRepository.java
 * Dec 28, 2019
 */
package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.Addresses;
import com.mypractice.hrms.model.User;

/**
 * @author nasru
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Addresses, Integer> {

	/**
	 * @param user
	 * @return
	 */
	@Query("select a.addressID as addressID, a.pinCode as pinCode, a.addressDetails as addressDetails, c.cityID as cityID  from  Addresses a inner join CityMaster c on a.cityMst  = c.cityID  where a.user = :USERID")
	AddressDetails getUserDetails(@Param("USERID") User userID);

}
