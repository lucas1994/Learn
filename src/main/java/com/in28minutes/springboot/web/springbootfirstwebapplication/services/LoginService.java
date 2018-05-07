package com.in28minutes.springboot.web.springbootfirstwebapplication.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean isValidUser (String userId, String password) {
		
		return userId.equalsIgnoreCase("user") && password.equals("password");
	}
	
	

}
