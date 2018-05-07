package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.springboot.web.springbootfirstwebapplication.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService login;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginMessage(ModelMap model) {
		// model.put("name", name);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (!login.isValidUser(name, password)) {
			String invalid = "Invalid Credentials!";
			model.put("errorMessage",invalid) ;
			return "login";
		}

		else {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
	}

}
