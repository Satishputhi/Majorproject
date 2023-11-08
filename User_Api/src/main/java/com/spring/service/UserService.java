package com.spring.service;

import com.spring.request.LoginRequest;
import com.spring.request.PwdChangeRequest;
import com.spring.request.SighUpRequest;
import com.spring.response.LoginResponse;
import com.spring.response.SignUpResponse;

public interface UserService {
	public SignUpResponse saveUser(SighUpRequest request);
	
	public LoginResponse userLogin(LoginRequest request);
	
	public LoginResponse updatePwd(PwdChangeRequest request);
	
	public boolean recoverPwd(String email);

}
