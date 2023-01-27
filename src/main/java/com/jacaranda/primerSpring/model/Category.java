	package com.jacaranda.primerSpring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
		
		@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
		private Integer id;
		private String genres;
		private String descriptionCategory;
		
		@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
		List<Movies> movieList; 

		public Category(Integer id,String genres, String description_name) {
			super();
			this.id= id;
			this.genres = genres;
			this.descriptionCategory = description_name;
			this.movieList = null;
		}

		public Category() {
			
	
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getGenres() {
			return genres;
		}

		public void setGenres(String genres) {
			this.genres = genres;
		}

		
		

		

		public String getDescriptionCategory() {
			return descriptionCategory;
		}

		public void setDescriptionCategory(String descriptionCategory) {
			this.descriptionCategory = descriptionCategory;
		}

		public List<Movies> getMovieList() {
			return movieList;
		}

		public void setMovieList(List<Movies> movieList) {
			this.movieList = movieList;
		}

		

		@Override
		public int hashCode() {
			return Objects.hash(descriptionCategory, genres, id, movieList);
		}

		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Category other = (Category) obj;
			return Objects.equals(descriptionCategory, other.descriptionCategory)
					&& Objects.equals(genres, other.genres) && Objects.equals(id, other.id)
					&& Objects.equals(movieList, other.movieList);
		}

		@Override
		public String toString() {
			return "Category [id=" + id + ", genres=" + genres + ", description_name=" + descriptionCategory
					+ ", itemList=" + movieList + "]";
		}
		
		

}
