/**
 * nasru
 * ApplicationPreviewBean.java
 * Jan 19, 2020
 */
package com.mypractice.hrms.bean;

import java.util.List;

/**
 * @author nasru
 *
 */
public class ApplicationPreviewBean {
	private UserBean userBean;
	private AddressBean addressBean;
	private List<ApplicationBean> applicationBean;
	private String encodePhoto;
	/**
	 * @return the userBean
	 */
	public UserBean getUserBean() {
		return userBean;
	}
	/**
	 * @return the addressBean
	 */
	public AddressBean getAddressBean() {
		return addressBean;
	}
	/**
	 * @return the applicationBean
	 */
	public List<ApplicationBean> getApplicationBean() {
		return applicationBean;
	}
	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	/**
	 * @param addressBean the addressBean to set
	 */
	public void setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
	}
	/**
	 * @param applicationBean the applicationBean to set
	 */
	public void setApplicationBean(List<ApplicationBean> applicationBean) {
		this.applicationBean = applicationBean;
	}
	/**
	 * @return the encodePhoto
	 */
	public String getEncodePhoto() {
		return encodePhoto;
	}
	/**
	 * @param encodePhoto the encodePhoto to set
	 */
	public void setEncodePhoto(String encodePhoto) {
		this.encodePhoto = encodePhoto;
	}

}
