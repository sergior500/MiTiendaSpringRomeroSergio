package com.jacaranda.primerSpring.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity	
public class Movies {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	private String title;
	private String descriptionMovie;
	private double price;
	private int stock;
	@ManyToOne
	@JoinColumn (name="category_id")
	private Category category;
	@OneToMany(mappedBy="movie")
	private List<Purchase> purchases;
	

	

	public Movies() {
		
	}




	public Movies(Integer id, String title, String description_movie, double price, int stock, Category category_id) {
		super();
		this.id = id;
		this.title = title;
		this.descriptionMovie = description_movie;
		this.price = price;
		this.stock = stock;
		this.category = category_id;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}


	





	



	public String getDescriptionMovie() {
		return descriptionMovie;
	}




	public void setDescriptionMovie(String descriptionMovie) {
		this.descriptionMovie = descriptionMovie;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public int getStock() {
		return stock;
	}




	public void setStock(int stock) {
		this.stock = stock;
	}




	




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	@Override
	public int hashCode() {
		return Objects.hash(category, descriptionMovie, id, price, stock, title);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		return Objects.equals(category, other.category)
				&& Objects.equals(descriptionMovie, other.descriptionMovie) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && stock == other.stock
				&& Objects.equals(title, other.title);
	}




	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", description_movie=" + descriptionMovie + ", price=" + price
				+ ", stock=" + stock + ", category_id=" + category + "]";
	}
	
	
	
	
	

}
