package com.spring.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String planName;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startdate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endDate;
	private String planCategory;
	private String updatePlan;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getUpdatePlan() {
		return updatePlan;
	}
	public void setUpdatePlan(String updatePlan) {
		this.updatePlan = updatePlan;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public String getPlanCategory() {
		return planCategory;
	}
	public void setPlanCategory(String planCategory) {
		this.planCategory = planCategory;
	}
	public Plan() {
		super();
		
	}
	

}
