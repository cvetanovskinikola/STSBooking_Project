package com.getaway.weekend.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppErrorController {

	public ModelAndView errorDisplay(String message, HttpStatus status) {
		ModelAndView m = new ModelAndView("error-form");
		m.addObject("error", message);
		m.addObject("status", status.toString());
		return m;
	}
}

