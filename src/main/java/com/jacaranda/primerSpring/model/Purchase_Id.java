package com.jacaranda.primerSpring.model;

import java.io.Serializable;
import java.util.Objects;

public class Purchase_Id implements Serializable{

	private Integer movie;
	private Integer order;
	
	public Purchase_Id() {
		
	}

	public Integer getMovie() {
		return movie;
	}

	public void setMovie(Integer user) {
		this.movie = user;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, movie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase_Id other = (Purchase_Id) obj;
		return Objects.equals(order, other.order) && Objects.equals(movie, other.movie);
	}
	
}
