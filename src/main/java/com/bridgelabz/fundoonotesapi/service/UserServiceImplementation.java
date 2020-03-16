package com.bridgelabz.fundoonotesapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotesapi.dto.RegistrationDTO;
import com.bridgelabz.fundoonotesapi.model.User;
import com.bridgelabz.fundoonotesapi.repository.UserRepository;
import com.bridgelabz.fundoonotesapi.response.Response;
import com.bridgelabz.fundoonotesapi.utility.TokenUtility;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenUtility tokenUtility;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Response addUser(RegistrationDTO registrationDTO) {
		User checkEmail = userRepository.findByEmail(registrationDTO.getEmail());
		if (checkEmail != null) {
			return new Response(200, "Invalid User", false);
		}
		User user = mapper.map(registrationDTO, User.class);
		System.out.println(registrationDTO.getEmail());
		String token = tokenUtility.generateToken(user.getEmail());
		System.out.println(token);
		
		user.setPassword(registrationDTO.getPassword());
		userRepository.save(user);
		return new Response(200, "User Registration Successfull", token);

	}
	

	
}
