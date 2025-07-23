package com.fabio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
