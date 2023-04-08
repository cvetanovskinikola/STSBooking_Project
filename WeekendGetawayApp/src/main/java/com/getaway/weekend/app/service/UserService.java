package com.getaway.weekend.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.getaway.weekend.app.dto.UserRegistrationDto;
import com.getaway.weekend.app.entity.User;


public interface UserService extends UserDetailsService{
	User saveUser(UserRegistrationDto registrationDto);

}
