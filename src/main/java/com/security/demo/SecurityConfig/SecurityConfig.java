package com.security.demo.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	
	// Authentication
	
	@Bean
	public UserDetailsService  detailsService( PasswordEncoder encoder) {
		
		
		UserDetails Admin= User.
				withUsername("robel").
				password(encoder.encode("12345")).
				roles("ADMIN").
				build();
		
		
		UserDetails norlamUser= User.
				withUsername("xyz").
				password(encoder.encode("12345678")).
				roles("USER").
				build();
			
	
		return new InMemoryUserDetailsManager(Admin,norlamUser);
		
		
	}
	
	
	// Authtorization
	
	@Bean
	public SecurityFilterChain securityFilterChain( HttpSecurity http) throws Exception  {
		
		
		return 
	     http
		.authorizeHttpRequests().requestMatchers("/homepage").permitAll()
		.and()
		.authorizeHttpRequests().requestMatchers("/hi","/alluser").authenticated()
		.and()
		.httpBasic()
		.and().build();
		
		
		
	}
	
	
	// Password Encode
	
	
	@Bean
	public PasswordEncoder encoder() {
		
		
		return new BCryptPasswordEncoder();
	}
	
	
	// Authentication Provider
	
	
	
}
