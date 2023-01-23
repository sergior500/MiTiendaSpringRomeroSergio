package com.jacaranda.primerSpring.service;

import java.util.List;

import javax.lang.model.element.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Category;
import com.jacaranda.primerSpring.model.Movies;
import com.jacaranda.primerSpring.repository.MoviesRepository;

@Service
public class MoviesService {

	

	@Autowired
	private MoviesRepository repository;
	@Autowired
	private CategoryService categoryService;
	
	public List<Movies> getItems() {
		return repository.findAll();
	}
	
	public Movies findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Page<Movies> findAll(int pageNum, int pageSize, String sortFile, String stringFind, Integer idCategory) {
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, Sort.by(sortFile).ascending());
		Category c= categoryService.getCategory(idCategory);
	if( stringFind ==null) {	
		if(idCategory!=0) {
			return repository.findByCategory(c, pageable);
		}else {
			return repository.findAll(pageable);
		}	
	}else {
		if(idCategory!=0) {
			return repository.findByCategory(c, pageable);
		}else {
			return repository.findByTitleLike("%"+ stringFind +"%", pageable);
		}
	}
		
		
	}
	
	public Movies getItem(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Movies addItem(Movies movie) {
		if ( movie.getTitle() != null && movie.getDescriptionMovie() != null && movie.getStock() > 0
				 && movie.getPrice() > 0) {
			return repository.save(movie);
		}
		return null;
	}
	
	public boolean deleteItem(Movies movie) {
		boolean deleted = false;
		
		if(this.getItem(movie.getId()) != null) {
			repository.delete(movie);
			deleted = true;
		}
		
		return deleted;
	}
	
	public Movies updateItem(Movies movie) {
		Movies movies = null;
		if(movie.getId() != null && movie.getTitle() != null && movie.getDescriptionMovie() != null && movie.getStock() > 0
				&& movie.getCategory() != null && movie.getPrice() > 0) {
			movies = this.getItem(movie.getId());
			
			movies.setTitle(movie.getTitle());;
			movies.setDescriptionMovie(movie.getDescriptionMovie());
			movies.setPrice(movie.getPrice());
			movies.setStock(movie.getStock());
			movies.setCategory(movie.getCategory());;
			
			movies = repository.save(movies);
		}
		
		return movies;
	}
	
}
