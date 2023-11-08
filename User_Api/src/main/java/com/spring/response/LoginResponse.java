package com.spring.response;

public class LoginResponse {
	private Integer userid;
	private String name;
	private String userType;
	private DashboardResponse dashboard;
	private boolean validLogin;
	private String pwdChanged;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public DashboardResponse getDashboard() {
		return dashboard;
	}
	public void setDashboard(DashboardResponse dashboard) {
		this.dashboard = dashboard;
	}
	public boolean isValidLogin() {
		return validLogin;
	}
	public void setValidLogin(boolean validLogin) {
		this.validLogin = validLogin;
	}
	public String getPwdChanged() {
		return pwdChanged;
	}
	public void setPwdChanged(String pwdChanged) {
		this.pwdChanged = pwdChanged;
	}
	
	
	


	

}
	
