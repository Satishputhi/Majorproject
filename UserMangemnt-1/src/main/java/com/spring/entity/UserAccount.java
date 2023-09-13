package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class UserAccount {
	@Id
	@GeneratedValue
	private Integer userid;
    private String fullname;
    private String email;
    private Long PHNO;
    private String Gender;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate DOB;
    private Long SSN;
    private String Active_Sw;
    

    @CreationTimestamp
    @Column(updatable=false)
    private LocalDate createdate;
    @UpdateTimestamp
    @Column(insertable=false)
    private LocalDate updatedate;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPHNO() {
		return PHNO;
	}
	public void setPHNO(Long pHNO) {
		PHNO = pHNO;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public Long getSSN() {
		return SSN;
	}
	public void setSSN(Long sSN) {
		SSN = sSN;
	}
	public String getActive_Sw() {
		return Active_Sw;
	}
	public void setActive_Sw(String active_Sw) {
		Active_Sw = active_Sw;
	}
	public LocalDate getCreatedate() {
		return createdate;
	}
	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}
	public LocalDate getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(LocalDate updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", fullname=" + fullname + ", email=" + email + ", PHNO=" + PHNO + ", Gender="
				+ Gender + ", DOB=" + DOB + ", SSN=" + SSN + ", Active_Sw=" + Active_Sw + ", createdate=" + createdate
				+ ", updatedate=" + updatedate + "]";
	}
    
    

}
