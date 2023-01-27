package com.jacaranda.primerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.primerSpring.model.Purchase;
import com.jacaranda.primerSpring.model.Purchase_Id;


public interface PurchaseRepository extends JpaRepository<Purchase, Purchase_Id>  {
	
	
	}


