package com.getaway.weekend.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.getaway.weekend.app.service.AdminService;
import com.getaway.weekend.app.service.HotelService;

@Controller
@RequestMapping("/addmin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	HotelService hs;
	
	
//	@GetMapping(path = "/deleteUser")
//	public String deleteUser() {
//		adminService.removeUser(34l);
//		
//		return "redirect:/";
//	}
	
}
