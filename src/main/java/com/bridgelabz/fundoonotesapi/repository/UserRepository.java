package com.bridgelabz.fundoonotesapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotesapi.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Object>{
	User findByEmail(String email);
}
