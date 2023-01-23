package com.jacaranda.primerSpring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class MiTiendaSpringVillarrealVicenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiTiendaSpringVillarrealVicenteApplication.class, args);
	}
	@Bean
	public Cloudinary cloudinaryConfig() {
	Cloudinary cloudinary = null;
	Map config = new HashMap();
	config.put("cloud_name", "df7eewfeo");
	config.put("api_key", "423921685245849");
	config.put("api_secret", "n8hCH_uJfyYUtZc4QSdiPvWhocY");
	cloudinary = new Cloudinary(config);
	return cloudinary;
	}
}
