package com.spring.model;

public class Citizen {
	private String name;
	private String dob;
	private String gender;
	private String SSN;
	private String stateName;

	public Citizen() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Citizen(String name, String dob, String gender, String sSN, String stateName) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		SSN = sSN;
		this.stateName = stateName;
	}

}