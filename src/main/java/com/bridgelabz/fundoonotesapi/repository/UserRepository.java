package com.bridgelabz.fundoonotesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.fundoonotesapi.model.UserClass;
public interface UserRepository extends JpaRepository<UserClass, Object> {
	UserClass findByEmail(String email);
}
