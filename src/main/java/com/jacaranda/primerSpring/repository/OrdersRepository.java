package com.jacaranda.primerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.primerSpring.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
