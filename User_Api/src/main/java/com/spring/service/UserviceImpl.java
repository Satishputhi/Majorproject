package com.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.spring.entity.UserInfoEntity;
import com.spring.repo.UserInfoRepository;
import com.spring.request.LoginRequest;
import com.spring.request.PwdChangeRequest;
import com.spring.request.SighUpRequest;
import com.spring.response.DashboardResponse;
import com.spring.response.LoginResponse;
import com.spring.response.SignUpResponse;
import com.spring.utils.EmailUtiles;


@Service
public class UserviceImpl implements UserService {
	
	@Autowired
	private UserInfoRepository userRepo;
	
	@Autowired
	private EmailUtiles emailUtiles;

	@Override
	public SignUpResponse saveUser(SighUpRequest request) {
		
		SignUpResponse response = new  SignUpResponse();
		
		UserInfoEntity user = userRepo.findByEmail(request.getEmail());
			if (user != null) {
				response.setErrorMsg("Duplicate Email");
				return response;
			}
		
			
		
		String tempPwd = generaterandomPwd();
		
		request.setPwd(tempPwd);
		request.setPwdChanged("false");
		
		UserInfoEntity entity = new UserInfoEntity();
		BeanUtils.copyProperties(request, entity);
		userRepo.save(entity);
		
		String sub = "IES Account Created";
		
		String body = "Your Pwd To Login into IES : :" +tempPwd;
		
		boolean isSent = emailUtiles.sendEmail(entity.getEmail(),sub, body);
		
		if(isSent) {
			response.setSuccessMsg("Registartion Successful");
		}
		else {
			response.setErrorMsg("Registration failed");
		}
		return response;
	}

	@Override
	public LoginResponse userLogin(LoginRequest request) {
		LoginResponse response = new  LoginResponse();
		UserInfoEntity entity = new UserInfoEntity();
		entity.setEmail(request.getEmail());
		entity.setPwd(request.getPwd());
		Example<UserInfoEntity> of = Example.of(entity);
		List<UserInfoEntity> entities = userRepo.findAll(of);
		if (!entities.isEmpty()) {
		UserInfoEntity user = entities.get(0);
		response.setUserid(user.getUserid());
		response.setUserType(user.getUserType());
		if (user.getPwdChanged().equals("true")) {
		// Second login
		response.setPwdChanged("true");
		response.setValidLogin(true);
		response.setUserid(user.getUserid());
		response.setUserType(user.getUserType());
		// Set dashboard data
		DashboardResponse dashboard = new DashboardResponse();
		dashboard.setPlansCount(61L);
		dashboard.setBenefitAmtTotal(3400.00);
		dashboard.setCitizensApCnt(10001L);
		dashboard.setCitizenDnCnt(500L);
		response.setDashboard(dashboard);
		}else {
			response.setPwdChanged("false");
			response.setValidLogin(true);
		}
		
		}else {
			response.setValidLogin(false);
		}
		return response;
	}

	@Override
	public LoginResponse updatePwd(PwdChangeRequest request) {
			LoginResponse response = new LoginResponse();
			
			Integer userId = request.getUserid();
			
			Optional<UserInfoEntity> findById = userRepo.findById(userId);
			
			if (findById.isPresent()) {
				UserInfoEntity entity = findById.get();
				entity.setPwd(request.getPwd());
				entity.setPwdChanged("true");
				userRepo.save(entity);
				
				response.setUserid(entity.getUserid());
				response.setUserType(entity.getUserType());
				
				response.setValidLogin(true);
				response.setPwdChanged("true");
				
				DashboardResponse dashboard = new DashboardResponse();
				dashboard.setPlansCount(61L);
				dashboard.setBenefitAmtTotal(3400.00);
				dashboard.setCitizensApCnt(100011L);
				dashboard.setCitizenDnCnt(5001L);
				response.setDashboard(dashboard);
				
				
			}
		return response;
	}

	@Override
	public boolean recoverPwd(String email) {
		UserInfoEntity user = userRepo.findByEmail(email); 
		if (user == null) {
			return false;
		}
		
		String sub = "IES Password Recovered";
		
		String body = "Your Password : :"+user.getPwd();
		
		return emailUtiles.sendEmail(email, sub, body);
	}
	
	public String generaterandomPwd() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    StringBuilder sb = new StringBuilder();

	    Random random = new Random();
	   
	    int length = 5;

	    for(int i = 0; i < length; i++) {
	      int index = random.nextInt(alphabet.length());
	      char randomChar = alphabet.charAt(index);
	      sb.append(randomChar);
	    }
	   return sb.toString();

	  }

}
