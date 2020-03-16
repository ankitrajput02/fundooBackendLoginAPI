package com.bridgelabz.fundoonotesapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bridgelabz.fundoonotesapi.dto.LoginUserDTO;
import com.bridgelabz.fundoonotesapi.dto.UserDTO;
import com.bridgelabz.fundoonotesapi.model.UserClass;
import com.bridgelabz.fundoonotesapi.repository.UserRepository;
import com.bridgelabz.fundoonotesapi.response.Response;
import com.bridgelabz.fundoonotesapi.utility.TokenUtility;

import com.sun.istack.logging.Logger;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenUtility tokenUtility;
	@Autowired
	private ModelMapper mapper;
	PasswordEncoder passwordEncoder;

	@Override
	public Response newUserRegistration(UserDTO userDTO) {
		UserClass checkEmail = userRepository.findByEmail(userDTO.getEmail());
		if (checkEmail != null) {
			return new Response(200, "Invalid User", false);
		}
		UserClass userClass = mapper.map(userDTO, UserClass.class);
		System.out.println(userDTO.getEmail());
		String token = tokenUtility.generateToken(userClass.getEmail());
		System.out.println(token);

		userClass.setPassword(userDTO.getPassword());
		userRepository.save(userClass);
		return new Response(200, "User Registration Successfull", token);

	}

	@Override
	public Response loginUser(LoginUserDTO loginUserDTO) {
		// It is used in Mapped the Data-->JPA
		UserClass userClass = userRepository.findByEmail(loginUserDTO.getEmail());
		// To generate the Token
		String token = tokenUtility.generateToken(loginUserDTO.getEmail());
		// Print Token in Console
		System.out.println(token);
		if (userClass == null) {
			

		}
		return null;
		

	}

}
