package com.getaway.weekend.app.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.getaway.weekend.app.service.DestinationService;
import com.getaway.weekend.app.service.HotelService;
import com.getaway.weekend.app.service.UserService;


import com.getaway.weekend.app.controller.DestinationController;
import com.getaway.weekend.app.dto.DestinationDto;
import com.getaway.weekend.app.dto.UserRegistrationDto;
import com.getaway.weekend.app.entity.Destination;
import com.getaway.weekend.app.entity.Hotel;
import com.getaway.weekend.app.repository.DestinationRepo;

@Controller
public class DestinationController {


	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    }
	
	@Autowired
	DestinationRepo destRepo;
	
	@Autowired HotelService hotelService;
	
	private DestinationService destService;
	public DestinationController(DestinationService destService) {
		super();
		this.destService = destService;
	}
	@ModelAttribute("destination")
    public DestinationDto destDto() {
        return new DestinationDto();
    }
	
	@GetMapping("/admin/adding")
	public String showAddingForm() {
		return "adding";
	}
	@PostMapping("/admin/adding")
	public String addDestination(@ModelAttribute("destination") DestinationDto dd) {	
		destService.saveDestination(dd);
		return "redirect:/admin/addHotelForDestination?id="+ dd.getId();
	}
	
	
	@GetMapping(value = {"","/","home"})
	public String homePage() {
		return "index";
	}



	

	@GetMapping(value = "/destinations/destination")
	public ModelAndView destinationn( @RequestParam Long id) {
		ModelAndView model = new ModelAndView("destination");
		model.addObject("destination", destService.getDestinationById(id));
		return model;
	}
	@GetMapping(value = "/destinations")
	public String getDestinations(Model model) {
		model.addAttribute("destinations", destService.getAllDestinations());
		return "destinations";
	}
	
	@GetMapping("/admin/addHotelForDestination")
	public ModelAndView assingHotel(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("createHotelForDestination");
		Hotel hotel = new Hotel();
		hotel.setDestination(destService.getDestinationById(id));
		model.addObject("hotel", hotel);
		return model;
	}
	@PostMapping("/admin/destinations/destination/addHotel")
	public String saveHotelForDestination(@ModelAttribute Hotel hotel){
		Destination dest = hotel.getDestination();
		hotel = hotelService.saveHotel(hotel);
		dest.setHotel(hotel);
		destService.updateDest(dest);
		
		return "redirect:/destinations";
	}
	
	

	
}
