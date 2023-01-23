package com.jacaranda.primerSpring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jacaranda.primerSpring.service.UserLoginService;




@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private UserLoginService myUserDetailService;

	public WebSecurityConfig() {
		// TODO Auto-generated constructor stub
	}

	// Indicamos que la configuración se hará a travéx del servicio.
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(myUserDetailService);
		}

		// Método que usaremos más abajo
		@Bean
		public UserDetailsService userDetailsService() {
			return new UserLoginService();
		}

		// Método que nos suministrará la codificación
		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		// Método que autentifica
		@Bean
		public DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
			authProvider.setUserDetailsService(userDetailsService());
			authProvider.setPasswordEncoder(passwordEncoder());
			return authProvider;
		}

		// Aquí es donde podemos especificar qué es lo que hace y lo que no
		// según el rol del usuario
		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http.authorizeHttpRequests((requests) -> {
				requests.requestMatchers("/css/**").permitAll()
						.requestMatchers("/scss/**").permitAll()
						.requestMatchers("/js/**").permitAll()
						.requestMatchers("/usuario/list")
						.hasAnyAuthority("USER", "ADMIN")
						.requestMatchers("/").hasAnyAuthority("USER", "ADMIN")
						.requestMatchers("/usuario/list").hasAuthority("ADMIN")
						.requestMatchers("/usuario/add").hasAuthority("ADMIN")
						.requestMatchers("/usuario/admin").hasAuthority("ADMIN")
						.requestMatchers("/usuario/update/**").hasAnyAuthority("USER", "ADMIN")
						.requestMatchers("/usuario/delete/**").hasAuthority("ADMIN")
						.requestMatchers("/categoria/add").hasAuthority("ADMIN")
						.requestMatchers("/categoria/delete/**").hasAuthority("ADMIN")
						.requestMatchers("/categoria/update/**").hasAuthority("ADMIN")
						.requestMatchers("/articulo/add").hasAuthority("ADMIN")
						.requestMatchers("/articulo/delete/**").hasAuthority("ADMIN")
						.requestMatchers("/articulo/update/**").hasAuthority("ADMIN")
						.requestMatchers("/categoria/list/**").hasAnyAuthority("USER", "ADMIN")
						.requestMatchers("/articulo/list").hasAnyAuthority("USER", "ADMIN")
						.requestMatchers("/sing_up").permitAll()
						.requestMatchers("/sing_up/submit").permitAll()
						.requestMatchers("/verify").permitAll()
						.anyRequest().authenticated();
			}).formLogin((form) -> form
					 .loginPage("/login")
					.permitAll()).logout((logout) -> logout.permitAll());
			return http.build();
		}

}
