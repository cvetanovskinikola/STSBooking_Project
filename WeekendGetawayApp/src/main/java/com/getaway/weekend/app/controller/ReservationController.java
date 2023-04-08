package com.getaway.weekend.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.getaway.weekend.app.dto.DestinationDto;
import com.getaway.weekend.app.dto.ReservationDto;
import com.getaway.weekend.app.entity.Destination;
import com.getaway.weekend.app.entity.Hotel;
import com.getaway.weekend.app.entity.Reservation;
import com.getaway.weekend.app.entity.User;
import com.getaway.weekend.app.repository.UserRepo;
import com.getaway.weekend.app.service.DestinationService;
import com.getaway.weekend.app.service.ReservationService;
import com.getaway.weekend.app.service.UserServiceImpl;

import lombok.SneakyThrows;

@Controller
public class ReservationController {
	

	@Autowired
	private UserServiceImpl usi;
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private DestinationService destService;
	private ReservationService rs;
	public ReservationController(ReservationService rs) {
		super();
		this.rs=rs;
	}
	
	@ModelAttribute("reservation")
    public Reservation res() {
        return new Reservation();
    }
//	@ModelAttribute("reservation")
//	public ReservationDto resDto() {
//		return new ReservationDto();
//	}
	@ModelAttribute("hotel")
	public Hotel hotel() {
		return new Hotel();
	}
	@ModelAttribute("destination")
	public Destination dest() {
		return new Destination();	
	}
	
	@GetMapping("/reservationForm")
	public ModelAndView reservationForm(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("reservationForm");
		Reservation reservation = new Reservation();
		reservation.setDestination(destService.getDestinationById(id));
		model.addObject("reservation", reservation);
		return model;
	}
	
	@PostMapping("/reserveDestination")
	public String makeReservation(@ModelAttribute @Valid Reservation res,Model model, BindingResult br) {
		model.addAttribute("reservation", res);
		if(br.hasErrors()) {
			return "reservationForm";
		}
//			Destination dest = res.getDestination();
			//rs.calcFinalPrice(res,dest.getId());
//			rs.reservationRequirements(res, dest.getId());
//			rs.updateUsers(res);
			res = rs.saveReservation(res);
//			dest.addReservation(res);
//			destService.updateDest(dest);
			
			return "redirect:/home";
	}
	@GetMapping(value = "/user/reservations")
	public String getReservations(Model model) {
		User user = ur.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("reservations", user.getReservations());
		return "reservations";
	}
	@GetMapping("/reservation/cancel")
	@SneakyThrows
	public String cancelRes(@RequestParam Long id,RedirectAttributes ra) {
		rs.cancelReservation(id);
		ra.addFlashAttribute("success", "You have successfully cancelled your reservation.");
		return "redirect:/";
	}
	
	
}
