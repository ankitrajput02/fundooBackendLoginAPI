package com.bridgelabz.fundoonotesapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotesapi.dto.UserDTO;
import com.bridgelabz.fundoonotesapi.model.UserClass;
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
	UserClass user;

	@Override
	public Response newUserRegistration(UserDTO userDTO) {
		UserClass checkEmail = userRepository.findByEmail(user.getEmail());
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

}
