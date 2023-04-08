package com.getaway.weekend.app.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getaway.weekend.app.entity.Destination;
import com.getaway.weekend.app.service.DestinationService;

@RestController
@RequestMapping("/admin")
public class DestinationApiController {

	@Autowired
	DestinationService destService;
	
	@GetMapping("/destinations")
	public List<Destination> showAllDestinations() {
		return destService.getAllDestinations();
	}
	@GetMapping("/destinations/{id}")
	public Destination showDestinationById(@PathVariable Long id) {
		return destService.getDestinationById(id);
	}
	@GetMapping("/view")
	public String getView() {
		return "the view";
	}
	
	
}
