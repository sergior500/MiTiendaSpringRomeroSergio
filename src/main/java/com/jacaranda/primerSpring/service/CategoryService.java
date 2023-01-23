package com.jacaranda.primerSpring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Category;
import com.jacaranda.primerSpring.model.Movies;
import com.jacaranda.primerSpring.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	
	public List<Category> getCategories() {
		return repository.findAll();
	}
	
	public Page<Category> findAll(int pageNum, int pageSize, String sortFile, String stringFind) {
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, Sort.by(sortFile).ascending());
		
		if( stringFind ==null) {
			return repository.findAll(pageable);
		}else {
			return repository.findByGenresLike("%"+ stringFind +"%", pageable);
		}
		
		
	}
	
	public Category getCategory(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Category addCategory(Category category) {
		Category saved = null;
		
		List<Movies> listMovies= new ArrayList<>();
		
		if ( category.getGenres()!=null && category.getDescriptionCategory() != null) {
			category.setMovieList(listMovies);
			saved = repository.save(category);
		}
		
		return saved;
	}
	
	public boolean deleteCategory(Category category) {
		boolean deleted = false;
		
		if(this.getCategory(category.getId()) != null) {
			
			repository.delete(category);
			deleted = true;
		}
		
		return deleted;
	}
	
	public Category updateCategory(Category categoryMod) {
		Category saved = null;
		Category cat = this.getCategory(categoryMod.getId());
		categoryMod.setMovieList(cat.getMovieList());
		
		if(categoryMod.getId() != null && categoryMod.getMovieList() != null && categoryMod.getDescriptionCategory() != null) {
			
			cat.setGenres(categoryMod.getGenres());
			cat.setDescriptionCategory(categoryMod.getDescriptionCategory());;
			saved = repository.save(cat);
		}
		
		return saved;
	}
	
	
}
