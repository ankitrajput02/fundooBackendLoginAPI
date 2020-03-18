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

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenUtility tokenUtility;
	@Autowired
	private ModelMapper mapper;
	//PasswordEncoder passwordEncoder;
	private PasswordEncoder PasswordEncoder;
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
	public Response isValidateUser(String token) {
		String email = tokenUtility.getToken(token);
		UserClass userClass = userRepository.findByEmail(email);
		if (userClass == null) {
			System.out.println("User not valid");
		} else {
			userClass.setSetValidate(true);
		}
		userRepository.save(userClass);
		return new Response(200, "Validate", token);

	}

	@Override
	public Response loginUser(LoginUserDTO loginUserDTO) {
		UserClass userClass = userRepository.findByEmail(loginUserDTO.getEmail());
		String token = tokenUtility.generateToken(loginUserDTO.getEmail());
		System.out.println(token);
		if (userClass == null) {
			return new Response(200, "Invalid User", false);
		}
		if(userClass.isSetValidate()) {
			if(PasswordEncoder.matches(loginUserDTO.getPassword(),userClass.getPassword())) {
				userRepository.save(userClass);
				return new Response(200, "Login Success", token);
			}
			else {
				return new Response(200, "User Already Login", token);
			}
		}
		return new Response(200,"Email Invalid", token);

	}

}
