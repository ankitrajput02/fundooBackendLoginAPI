package com.bridgelabz.fundoonotesapi.service;

import com.bridgelabz.fundoonotesapi.dto.RegistrationDTO;
import com.bridgelabz.fundoonotesapi.response.Response;

public interface UserService {
	Response addUser(RegistrationDTO registrationDTO);
}
