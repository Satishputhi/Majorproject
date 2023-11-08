package com.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.request.LoginRequest;
import com.spring.request.PwdChangeRequest;
import com.spring.request.SighUpRequest;
import com.spring.response.LoginResponse;
import com.spring.response.SignUpResponse;
import com.spring.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService service;

	@PostMapping("/user")
	public ResponseEntity<SignUpResponse> userRegistration(@RequestBody SighUpRequest request) {
		SignUpResponse response = service.saveUser(request);

		if (response.getSuccessMsg() != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else if (response.getErrorMsg().contains("Duplicate Eamil")) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/login")

	public ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest request) {
		LoginResponse response = service.userLogin(request);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping("/pwd-change")

	public ResponseEntity<LoginResponse> updatePwd(@RequestBody PwdChangeRequest request) {
		LoginResponse login = service.updatePwd(request);

		return new ResponseEntity<>(login, HttpStatus.OK);

	}

	@GetMapping("/recover-pwd/{email}")

	public ResponseEntity<String> recoverPwd(@PathVariable String email) {
		boolean isValid = service.recoverPwd(email);

		if (isValid) {

			return new ResponseEntity<>("Password sent to your email", HttpStatus.OK);

		} else {

			return new ResponseEntity<>("Invalid Email", HttpStatus.BAD_REQUEST);

		}

	}

}
