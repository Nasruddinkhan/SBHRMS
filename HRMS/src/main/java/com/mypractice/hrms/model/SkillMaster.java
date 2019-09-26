package com.mypractice.hrms.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.mypractice.hrms.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Entity
@Table(name = "SKILL_MASTER")
@ApiModel(description = "All skill elements details")
public final class SkillMaster extends BaseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4307020459690682248L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_master")
	@SequenceGenerator(name="skill_master", sequenceName = "skill_seq", allocationSize=1,initialValue = 1000)
	@Column(name="SKILL_ID",  nullable = false)
	private Integer skillID;
	@Column(name="SKILL_NAME", columnDefinition = CommonUtils.VARCHAR_50, nullable = false)
	@ApiModelProperty(notes = "Mininum 4 charecter is required")
	private String  skillName;
	@Column(name="ORDER_LEVEL",  nullable = false)
	private Integer orderlevl;
	@OneToMany(mappedBy = "skillMst", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<SkillElementMaster> skillEleItems ;
	
	public List<SkillElementMaster> getSkillEleItems() {
		return skillEleItems;
	}
	
	public void setSkillEleItems(List<SkillElementMaster> skillEleItems) {
		this.skillEleItems = skillEleItems;
	}

	public Integer getOrderlevl() {
		return orderlevl;
	}
	public void setOrderlevl(Integer orderlevl) {
		this.orderlevl = orderlevl;
	}
	public Integer getSkillID() {
		return skillID;
	}
	public void setSkillID(Integer skillID) {
		this.skillID = skillID;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
}
