package com.spring.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Admin;
import com.spring.model.Plan;
import com.spring.repository.AdminRepo;
import com.spring.repository.PlanRepo;

@Service
public class AdminServiceImp implements AdminService{

	
	@Autowired
	private AdminRepo adminrepo;
	
	@Autowired
	private PlanRepo planrepo;
	
	@Override
	public void createUser(Admin admin) {
		Integer id = admin.getId();
		if(id==null) {
			admin.setActiveSw("Y");
		}
		String randomPassword = generateRandomPassword();
		admin.setPassword(randomPassword);
		adminrepo.save(admin);
	    
	}
	@Override
	public void createPlan(Plan plan) {
		Integer id = plan.getId();
		if(id==null) {
			plan.setUpdatePlan("Y");
		}
		planrepo.save(plan);
		
	}
	@Override
	public List<Admin> listCaseworker() {
		
		return adminrepo.findAll();
	}
	@Override
	public List<Plan> listPlans() {
		
		return planrepo.findAll();
	}
	@Override
	public Admin updateCaseworker(Admin a, Integer id) {
		Admin admin =adminrepo.findById(id).get();
		admin.setFullname(a.getFullname());
		admin.setMobileNumber(a.getMobileNumber());
		admin.setDob(a.getDob());
		admin.setSsn(a.getSsn());
		return adminrepo.save(admin);
	}
	@Override
	public Plan updateplan(Plan p, Integer id) {
		Plan plan = planrepo.findById(id).get();
		plan.setPlanName(p.getPlanName());
		plan.setPlanCategory(p.getPlanCategory());
		plan.setStartdate(p.getStartdate());
		plan.setEndDate(p.getEndDate());
		return planrepo.save(plan);
	}
	private String generateRandomPassword() {
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[8];
		random.nextBytes(bytes);
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
		
	}
	@Override
	public Admin updateactiveSw(Integer id) {
		Admin admin = adminrepo.findById(id).orElse(null);
		if (admin!=null) {
			admin.setActiveSw(admin.getActiveSw().equals("Y") ? "N" : "Y");
			return adminrepo.save(admin);
		}
		return null;
	}
	@Override
	public Plan updatePlan(Integer id) {
		Plan plan = planrepo.findById(id).orElse(null);
		if (plan!=null) {
			plan.setUpdatePlan(plan.getUpdatePlan().equals("Y") ? "N" : "Y");
			return planrepo.save(plan);
		}
		return null;
	}
	
	
	

}
