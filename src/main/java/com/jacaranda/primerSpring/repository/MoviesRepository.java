package com.jacaranda.primerSpring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.primerSpring.model.Category;
import com.jacaranda.primerSpring.model.Movies;

public interface MoviesRepository extends JpaRepository <Movies, Integer>  {
	
	public Page<Movies> findByTitleLike(String keyword,
			Pageable pageable);
	
	public Page<Movies> findByCategory(Category category, Pageable pageable);
	}


