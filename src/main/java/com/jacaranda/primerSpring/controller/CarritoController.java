package com.jacaranda.primerSpring.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.model.Carrito;
import com.jacaranda.primerSpring.model.Movies;
import com.jacaranda.primerSpring.model.Orders;
import com.jacaranda.primerSpring.model.Purchase;
import com.jacaranda.primerSpring.model.Users;
import com.jacaranda.primerSpring.service.MoviesService;
import com.jacaranda.primerSpring.service.OrderService;
import com.jacaranda.primerSpring.service.PurchaseService;
import com.jacaranda.primerSpring.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CarritoController {

	private static final String REDIRECT_ITEM = "redirect:/articulo/list";

	@Autowired
	private HttpSession http;

	@Autowired
	private MoviesService service;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PurchaseService purchaseService;

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
		
		if (c == null) {
			c = new Carrito();
		}
		model.addAttribute("moviesList",c.getMoviesMap());
		
		return "listaCarrito";	
	}
	
	@GetMapping("/articulo/carrito/submit")
	public String purchase (Model model,Principal principal) {
		
		String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Users u = userService.getUser(principal.getName());
		
		Carrito c = (Carrito) http.getAttribute("c1");
		
		Orders o = new Orders(LocalDateTime.now(),u);
		orderService.saveOrder(o);
		
		for(Movies m1 : c.getMoviesMap().keySet()) {
			
			
			Purchase p = new Purchase(m1,o,c.getMoviesMap().get(m1));
			purchaseService.addPurchase(p);
			
			
		}
		
		return REDIRECT_ITEM;
	}
}
