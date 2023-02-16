package com.security.demo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Conttrollers {

	
	
	@GetMapping("/homepage")
	public String hello() {
		
		
		return "Hello this is spring security class";
	}
	
	@GetMapping("/hi")
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String hi() {
		
		
		return "hi this is spring security class";
	}
	
	@GetMapping("/alluser")
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
	
	public String fetchuserdata() {
		
		
		return "user information";
	}
	
}
