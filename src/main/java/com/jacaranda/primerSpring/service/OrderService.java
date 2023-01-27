package com.jacaranda.primerSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Orders;
import com.jacaranda.primerSpring.repository.OrdersRepository;

@Service
public class OrderService {

	@Autowired
	OrdersRepository repository;
	
	
	public void saveOrder(Orders o1) {
		
		if(o1.getDate() != null &&  o1.getIva() > 0 && o1.getUsername() != null) {
			repository.save(o1);
		}
		
	}
}
