package com.jacaranda.primerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.model.Carrito;
import com.jacaranda.primerSpring.model.Movies;
import com.jacaranda.primerSpring.service.MoviesService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CarritoController {

	private static final String REDIRECT_ITEM = "redirect:/articulo/list";

	@Autowired
	private HttpSession http;

	@Autowired
	private MoviesService service;

	@GetMapping({ "/articulo/carrito/add" })
	public String addCarrito(Model model, @RequestParam("quantity") Integer quant, @RequestParam("id") Integer id) {

		Movies m1 = service.getItem(id);
		Carrito c1 = (Carrito) http.getAttribute("c1");
		
		if (c1 == null) {
			c1 = new Carrito();
		}
		if (m1 != null && quant > 0) {
			c1.addCarrito(m1, quant);
			http.setAttribute("c1", c1);
		}
		return REDIRECT_ITEM;

	}
	
	@GetMapping("/articulo/carrito")
	public String getCarrito(Model model) {
		
		Carrito c = (Carrito) http.getAttribute("c1");

		model.addAttribute("moviesList",c.getMoviesMap());
		
		return "listaCarrito";
	}
}
