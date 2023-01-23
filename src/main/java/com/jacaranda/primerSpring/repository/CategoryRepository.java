package com.jacaranda.primerSpring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.primerSpring.model.Category;
import com.jacaranda.primerSpring.model.Movies;


public interface CategoryRepository extends JpaRepository<Category, Integer>  {
	
	
	public Page<Category> findByGenresLike(String keyword,
			Pageable pageable);
	
	
	}


