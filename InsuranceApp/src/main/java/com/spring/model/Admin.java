package com.spring.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@Column(unique = true)
private String email;
private String fullname;
private String mobileNumber;
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
private LocalDate dob;
private String ssn;
private String activeSw;
private String password;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFullname() {
	return fullname;
}

public void setFullname(String fullname) {
	this.fullname = fullname;
}

public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public String getSsn() {
	return ssn;
}

public void setSsn(String ssn) {
	this.ssn = ssn;
}

public String getActiveSw() {
	return activeSw;
}

public void setActiveSw(String activeSw) {
	this.activeSw = activeSw;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Admin() {
	super();
	// TODO Auto-generated constructor stub
}

}