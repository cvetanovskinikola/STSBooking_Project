package com.getaway.weekend.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.getaway.weekend.app.entity.Role;
import com.getaway.weekend.app.entity.User;
import com.getaway.weekend.app.repository.RoleRepo;
import com.getaway.weekend.app.repository.UserRepo;

import lombok.SneakyThrows;

@Service
public class AdminService {

	@Autowired UserRepo userRepo;
	@Autowired RoleRepo roleRepo;
	
	//@Transactional
	//public void removeUser(Long id) {
	//	userRepo.deleteById(id);
	//}
	
	//User user = userRepo.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

	
}
