package com.jacaranda.primerSpring.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(Purchase_Id.class)
public class Purchase {
	
	@Id
	@ManyToOne
	@JoinColumn(
            name="id_movie"
            )
	private Movies movie;
	@Id
	@ManyToOne
	@JoinColumn(
            name="id_purchase"
            )
	private Orders order;
	
	private Integer quantity;

	public Purchase() {
		super();

	}
	
	public Purchase(Movies movie, Orders order, Integer quantity) {
		super();
		this.movie = movie;
		this.order = order;
		this.quantity = quantity;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movie, order, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		return Objects.equals(movie, other.movie) && Objects.equals(order, other.order)
				&& Objects.equals(quantity, other.quantity);
	}
	
	
	
}
