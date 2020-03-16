package com.bridgelabz.fundoonotesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotesapi.dto.UserDTO;
import com.bridgelabz.fundoonotesapi.response.Response;
import com.bridgelabz.fundoonotesapi.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/adduser")
	public ResponseEntity<String> newUserRegistration(@RequestBody UserDTO userDTO) {
		Response response = service.newUserRegistration(userDTO);
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
	}

}
