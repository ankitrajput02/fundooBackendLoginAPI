package com.bridgelabz.fundoonotesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotesapi.dto.RegistrationDTO;
import com.bridgelabz.fundoonotesapi.response.Response;
import com.bridgelabz.fundoonotesapi.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody RegistrationDTO registrationDTO) {
		Response response = service.addUser(registrationDTO);
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
	}

}
