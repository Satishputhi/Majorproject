package com.spring.service;

import java.util.List;

import com.spring.model.Admin;
import com.spring.model.Plan;

public interface AdminService {
	public void createUser(Admin admin);
	public void createPlan(Plan plan);
	public List<Admin> listCaseworker();
	public List<Plan> listPlans();
	public Admin updateCaseworker(Admin admin,Integer id);
	public Plan updateplan(Plan plan,Integer id);
	public Admin updateactiveSw(Integer id);
	Plan updatePlan(Integer id);

}
