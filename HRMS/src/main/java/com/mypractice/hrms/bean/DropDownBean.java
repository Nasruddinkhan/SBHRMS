 /**
 * 
 */
 package com.mypractice.hrms.bean;
 /**
 * @author Nasruddin Khan 
 * 14-Sep-2019 - 2:20:56 pm
 * DropDownBean.java
 */
 public class DropDownBean {
	 private String id;
	 private String code;
	public String getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public DropDownBean(String id, String code) {
		super();
		this.id = id;
		this.code = code;
	}
	public DropDownBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DropDownBean [id=" + id + ", code=" + code + "]";
	}
	
	 
}

 
