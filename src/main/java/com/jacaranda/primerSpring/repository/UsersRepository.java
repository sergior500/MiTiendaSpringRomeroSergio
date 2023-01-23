package com.jacaranda.primerSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.primerSpring.model.Users;


public interface UsersRepository extends JpaRepository<Users, String>  {
	
	List<Users> findByEmail(String email);
	
	}


