package com.spring.Restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Admin;

import com.spring.model.Plan;
import com.spring.repository.AdminRepo;
import com.spring.service.AdminServiceImp;

@RestController
public class AdminController {
	@Autowired
	private AdminRepo adminrepo;
	@Autowired
	private AdminServiceImp adminserviceImp;
	
	@PostMapping("/save")
	public String saveCaseWorker(@RequestBody Admin admin) {
		adminserviceImp.createUser(admin);
		return "Case Worker Added Succsessfully";
	}
	
	@PostMapping("/saveplan")
	public String savePlan(@RequestBody Plan plan) {
		adminserviceImp.createPlan(plan);
		return "Plan Added Succesfully";
	}
	
	@GetMapping("/caseworker")
	public List<Admin> liscaseworker() {
		return adminserviceImp.listCaseworker();
	}
	
	@GetMapping("/plan")
	public List<Plan> plan() {
		return adminserviceImp.listPlans();
	}
	
	@PutMapping("/caseWorker/{id}")
	public Admin update(@RequestBody Admin a,@PathVariable("id") Integer id) {
		return adminserviceImp.updateCaseworker(a, id);
		
	}
	@PutMapping("/plan/{id}")
	public Plan updatePlans(@RequestBody Plan p,@PathVariable("id") Integer id) {
		return adminserviceImp.updateplan(p, id);
		
	}
	
	@PutMapping("/updateStatus/{id}")
	public Admin updateSatus(@PathVariable Integer id) {
		return adminserviceImp.updateactiveSw(id);
	}
	
	@PutMapping("/updatePlan/{id}")
	public Plan updatePlan(@PathVariable Integer id) {
		return adminserviceImp.updatePlan(id);
	}

}
