package com.getaway.weekend.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.getaway.weekend.app.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminApi {

	@Autowired AdminService adminService;
	

	
	
}
