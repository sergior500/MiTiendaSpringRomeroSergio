package com.jacaranda.primerSpring.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	private int cod;
	private LocalDateTime date;
	private int iva;
	@ManyToOne
	@JoinColumn(name="username")
	private Users username;
	@OneToMany
	@JoinColumn(name="id_purchase")
	private List<Purchase> purchases;
	
	public Orders() {
		super();
	}
	
	public Orders(int cod, LocalDateTime date , Users username) {
		super();
		this.cod = cod;
		this.date = date;
		this.iva = 21;
		this.username = username;
		this.purchases = new ArrayList<Purchase>();
	}
	
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public Users getUsername() {
		return username;
	}
	public void setUsername(Users username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod, date, iva, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return cod == other.cod && Objects.equals(date, other.date) && iva == other.iva
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Orders 'cod=" + cod + ", date=" + date + ", iva=" + iva + ", username=" + username + "'";
	}
	
}
