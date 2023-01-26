package com.jacaranda.primerSpring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.model.Carrito;
import com.jacaranda.primerSpring.model.Movies;
import com.jacaranda.primerSpring.service.CategoryService;
import com.jacaranda.primerSpring.service.MoviesService;

import jakarta.servlet.http.HttpSession;



@Controller
public class MoviesController {
	
	private static final String REDIRECT_ITEM = "redirect:/articulo/list";
	
	
	@Autowired
	private HttpSession http;
	
	@Autowired
	private MoviesService service;
	
	@Autowired
	private CategoryService categoryService;
	
	

	
	@GetMapping({"/articulo/list" })
	public String getElements(Model model, @RequestParam("pageNumber") Optional<Integer> pageNumber,
			@RequestParam("sizeNumber") Optional<Integer> sizeNumber,
			@RequestParam("sortField") Optional<String> sortField,
			@RequestParam("stringFind") Optional<String> stringFind,
			@RequestParam("idCategoria") Optional<Integer> idCategoria){
				
		Page<Movies> page = service.findAll(pageNumber.orElse(1), sizeNumber.orElse(10), sortField.orElse("id"), 
				stringFind.orElse(null), idCategoria.orElse(0));
		
		model.addAttribute("currentPage", pageNumber.orElse(1));
		model.addAttribute("idCategoria", idCategoria.orElse(0));
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField.orElse("id"));
		model.addAttribute("keyword", stringFind.orElse(""));
		model.addAttribute("moviesList", page.getContent());
		
		return "moviesList";
	}
	
	@GetMapping("articulo/add")
	public String addItem(Model model) {
		
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("movie", new Movies());
		
		return "addMovie";
	}
	
	@PostMapping("articulo/add/submit")
	public String addItemSubmit(@ModelAttribute Movies movie) {
		
		service.addItem(movie);
		
		return REDIRECT_ITEM;
	}
	
	@GetMapping("/articulo/delete")
	public String deleteItem(@RequestParam Integer id ,Model model) {
		
		model.addAttribute("movie", service.getItem(id));
		
		return "deleteMovie";
	}
	
	@PostMapping("/articulo/delete/submit")
	public String deleteItemSubmit(@ModelAttribute Movies movie) {
		
		service.deleteItem(movie);
		
		return REDIRECT_ITEM;
	}
	
	@GetMapping("/articulo/update")
	public String updateItem(@RequestParam Integer id ,Model model) {
		
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("movie", service.getItem(id));
		
		return "updateMovie";
	}
	
	@PostMapping("/articulo/update/submit")
	public String updateItemSubmit(@ModelAttribute Movies movie) {
		
		service.updateItem(movie);
		
		return REDIRECT_ITEM;
	}


}
