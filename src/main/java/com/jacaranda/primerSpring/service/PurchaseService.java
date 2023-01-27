package com.jacaranda.primerSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Purchase;
import com.jacaranda.primerSpring.repository.MoviesRepository;
import com.jacaranda.primerSpring.repository.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	PurchaseRepository repository;
	
	@Autowired
	MoviesRepository movieRepository;
	
	
	public void addPurchase(Purchase p1) {
		if(p1.getMovie() != null && p1.getOrder() != null && p1.getQuantity() != null){
			p1.getMovie().setStock(p1.getMovie().getStock()-p1.getQuantity());
			
			repository.save(p1);
			movieRepository.save(p1.getMovie());
		}
	}
}
