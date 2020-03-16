package com.bridgelabz.fundoonotesapi.service;

import com.bridgelabz.fundoonotesapi.dto.UserDTO;
import com.bridgelabz.fundoonotesapi.response.Response;

public interface UserService {
	Response newUserRegistration(UserDTO userDTO);
}
