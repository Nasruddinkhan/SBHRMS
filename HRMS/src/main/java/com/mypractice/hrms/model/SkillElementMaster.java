 /**
 * 
 */
 package com.mypractice.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mypractice.hrms.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author Nasruddin Khan 
 * 29-May-2019 - 12:56:38 am
 * SkillElementMaster.java
 */
@Table(name ="SKILL_ELEMENT_MASTER" )
@Entity
@ApiModel(description = "return all skill details ")
public class SkillElementMaster extends BaseBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 771515757820769100L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_element_master")
	@SequenceGenerator(name="skill_element_master", sequenceName = "skill_element_seq", allocationSize=1,initialValue = 1000)
	@Column(name="SKILL_ELEMENT_ID",  nullable = false)
	private Integer skillElementID;
	@ApiModelProperty(notes = "cannnot be empty and maximum five length is required")
	@NotBlank(message = "skillElementName is mandatory")
	@Column(name ="SKILL_ELEMENT_NAME", columnDefinition = CommonUtils.VARCHAR_100)
	private String skillElementName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SKILL_ID" , foreignKey = @ForeignKey(name="FK_SKILL_ID_SKL_ELE_MENT"))
	@JsonIgnore
	private SkillMaster skillMst;
	@NotNull(message = "order level is mandatory")
	@Column(name="ORDER_LEVEL",  nullable = false)
	private Integer orderlevl;
	public Integer getSkillElementID() {
		return skillElementID;
	}
	public String getSkillElementName() {
		return skillElementName;
	}
	public SkillMaster getSkillMst() {
		return skillMst;
	}
	public Integer getOrderlevl() {
		return orderlevl;
	}
	public void setSkillElementID(Integer skillElementID) {
		this.skillElementID = skillElementID;
	}
	public void setSkillElementName(String skillElementName) {
		this.skillElementName = skillElementName;
	}
	public void setSkillMst(SkillMaster skillMst) {
		this.skillMst = skillMst;
	}
	public void setOrderlevl(Integer orderlevl) {
		this.orderlevl = orderlevl;
	}
	@Override
	public String toString() {
		return "SkillElementMaster [skillElementID=" + skillElementID + ", skillElementName=" + skillElementName
				+ ", skillMst=" + skillMst + ", orderlevl=" + orderlevl + "]";
	}
	

}

 
