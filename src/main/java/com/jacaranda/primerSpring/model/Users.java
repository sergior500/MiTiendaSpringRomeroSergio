package com.jacaranda.primerSpring.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users implements UserDetails {
	
		@Id
		private String username;
		private String password;
		private String first_name;
		private String email;
		private boolean admin;
		private String verificationCode;
		private boolean enabled;
		private String role;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	

	public Users(String username, String password, String first_name, String email, boolean admin,
			String verificationCode, boolean enabled, String role) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.email = email;
		this.admin = admin;
		this.verificationCode = verificationCode;
		this.enabled = enabled;
		this.role = role;
	}






	@Override
	public int hashCode() {
		return Objects.hash(username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(username, other.username);
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isAdmin() {
		return admin;
	}



	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



	public String getVerificationCode() {
		return verificationCode;
	}



	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		 authorities.add(new SimpleGrantedAuthority(this.role));

		 return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}



	@Override
	public String getPassword() {
		return this.password;
	}



	@Override
	public String getUsername() {
		return this.username;
	}

	
	
}
