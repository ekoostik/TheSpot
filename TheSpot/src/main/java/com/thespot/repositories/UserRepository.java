package com.thespot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thespot.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);	
	
	
}
