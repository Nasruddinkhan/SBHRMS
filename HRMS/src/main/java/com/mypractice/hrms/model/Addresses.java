/**
* 
*/
package com.mypractice.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Nasruddin Khan 02-Oct-2019 - 3:31:35 pm Addresses.java
 */
@Entity
@Table(name = "USER_ADDRESS_DETAILS")
public class Addresses extends BaseBean{
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_master")
	@SequenceGenerator(name="address_master", sequenceName = "address_master_seq", allocationSize=1,initialValue = 100)
	@Id
	@Column(name = "ADDRESS_ID")
	private Integer addressID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID" , foreignKey = @ForeignKey(name="FK_ADDRESS_CITY_ID"))
	@JsonIgnore
	private CityMaster 	cityMst;
	@Column(name = "PIN_CODE")
	private Integer 	pinCode;
	@Column(name = "ADREESS_DETAILS")
	private String addressDetails;
	
	@OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name="FK_ADDRESS_USER_ID"))
	@JsonIgnore
    private User user;
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the addressID
	 */
	public Integer getAddressID() {
		return addressID;
	}
	/**
	 * @return the cityMst
	 */
	public CityMaster getCityMst() {
		return cityMst;
	}
	/**
	 * @return the pinCode
	 */
	public Integer getPinCode() {
		return pinCode;
	}
	/**
	 * @return the addressDetails
	 */
	public String getAddressDetails() {
		return addressDetails;
	}
	/**
	 * @param addressID the addressID to set
	 */
	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}
	/**
	 * @param cityMst the cityMst to set
	 */
	public void setCityMst(CityMaster cityMst) {
		this.cityMst = cityMst;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @param addressDetails the addressDetails to set
	 */
	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}


}
