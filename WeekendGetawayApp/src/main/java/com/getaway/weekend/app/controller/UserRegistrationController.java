package com.getaway.weekend.app.controller;

import javax.validation.Valid;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.getaway.weekend.app.dto.UserRegistrationDto;
import com.getaway.weekend.app.exception.WrongInputInfoException;
import com.getaway.weekend.app.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto urd,BindingResult br) {	
		if(br.hasErrors()) {	
			throw new WrongInputInfoException("We couldn't register your account.Please make sure your name and last name contain at least 4 characters, you are over 18 years old,"
					+ "your password contains at least 7 characters, your credit card number and your email are valid.");
		}
		
		userService.saveUser(urd);
		
		return "redirect:/registration?success";
	}

	
	
}
