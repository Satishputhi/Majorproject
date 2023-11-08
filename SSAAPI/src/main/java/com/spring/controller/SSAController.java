package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Citizen;
import com.spring.service.CitizenService;

@RestController
@RequestMapping("/api/citizen")
public class SSAController {
	@Autowired
	private CitizenService citizenService;

	@PostMapping("/process")
	public Citizen processCitizen(@RequestBody Citizen citizen) {
		return citizenService.processCitizen(citizen);
	}
}
