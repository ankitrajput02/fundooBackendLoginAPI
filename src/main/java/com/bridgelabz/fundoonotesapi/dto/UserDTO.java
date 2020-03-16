package com.bridgelabz.fundoonotesapi.dto;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class UserDTO {
	@Valid
	@NotEmpty(message = "please provide first name")
	private String firstName;
	@Valid
	@NotEmpty(message = "please provide last name")
	private String lastName;
	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	@Size(min = 8, max = 30)
	private String password;
	@NotBlank(message = "please provide mobile no.")
	private long phone;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public long getPhone() {
		return phone;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "RegistrationDTO [firstName=" + firstName + ",  lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + "]";
	}

}
