package com.jacaranda.primerSpring.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Carrito {
	
	private Map<Movies, Integer> moviesMap;
	
	
	public Carrito () {
		super();
		this.moviesMap = new HashMap<Movies, Integer>();
	}
	
	public void addCarrito(Movies m1, Integer quatity) {
		
		if (m1 != null) {
			if(this.moviesMap.containsKey(m1)) {
				this.moviesMap.put(m1, this.moviesMap.get(m1) + quatity);
			}else {
				this.moviesMap.put(m1, quatity);
			}
		}
		
	}
	
	public void removeAllMovies () {
		this.moviesMap.clear();
	}
	
	public void removeOneItem (Movies m1) {
		if(m1 != null) {
			if(this.moviesMap.containsKey(m1)) {
				this.moviesMap.remove(m1);
			}
		}
	}

	public Map<Movies, Integer> getMoviesMap() {
		return moviesMap;
	}

	public void setMoviesMap(Map<Movies, Integer> moviesMap) {
		this.moviesMap = moviesMap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(moviesMap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		return Objects.equals(moviesMap, other.moviesMap);
	}

	@Override
	public String toString() {
		return "Carrito:" + moviesMap;
	}
	
	
	
}
