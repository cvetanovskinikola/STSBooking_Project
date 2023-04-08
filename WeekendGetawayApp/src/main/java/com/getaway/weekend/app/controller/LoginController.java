package com.getaway.weekend.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.getaway.weekend.app.entity.User;
import com.getaway.weekend.app.repository.UserRepo;

@Controller
public class LoginController {
	
	@Autowired
	UserRepo ur;
//
	@GetMapping("/login")
	public String login(@ModelAttribute User user) {	
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		
		return "index";
	}

}


