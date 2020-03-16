package com.bridgelabz.fundoonotesapi.dto;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class LoginUserDTO {
	@Email
	@NotEmpty(message = "Please provide valid email")
	private String email;

	@NotEmpty
	@Size(min = 8, max = 30)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginUserDTO [email=" + email + ", password=" + password + "]";
	}
}
