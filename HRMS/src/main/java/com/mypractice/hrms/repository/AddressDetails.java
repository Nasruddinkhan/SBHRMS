/**
 * nasru
 * AddressDetails.java
 * Dec 28, 2019
 */
package com.mypractice.hrms.repository;

/**
 * @author nasru
 *
 */
public interface AddressDetails {
	public Integer getAddressID();
	public Integer getCityID();
	public Integer getPinCode();
	public String getAddressDetails();
	public String getState();
}
