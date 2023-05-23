package com.getaway.weekend.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.getaway.weekend.app.controller.AppErrorController;

@ControllerAdvice
public class CustomControllerAdv {

	@Autowired AppErrorController controller;

	@ExceptionHandler(BindException.class)
	public ModelAndView handleExceptions(BindException e) {
		Map<String, String> errors = new HashMap<>();

		int i = 1;
		for (FieldError error : e.getFieldErrors()) {
			errors.put("Error " + i + ": ", error.getDefaultMessage());
			i++;
		}
		return controller.errorDisplay(mapToString(errors), HttpStatus.BAD_REQUEST);
	}

	private String mapToString(Map<String,String> errors) {
		String[] keys = errors.keySet().toArray(new String[errors.size()]);
		String[] values = errors.values().toArray(new String[errors.size()]);
		String result = "";
		for (int i = 0; i < keys.length; i++) {
			result += keys[i] + values[i] + " "; 
		}
		return result;
	}
	@ExceptionHandler(MoreGuestsNewException.class)
	public ModelAndView handleExceptions(MoreGuestsNewException e) {
		return controller.errorDisplay(e.error(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoRoomsOfYourChoiceLeftException.class)
	public ModelAndView handleExceptions(NoRoomsOfYourChoiceLeftException e) {
		return controller.errorDisplay(e.error(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoSpotsLeftForDestinationException.class)
	public ModelAndView handleExceptions(NoSpotsLeftForDestinationException e) {
		return controller.errorDisplay(e.error(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InsufficientFundsException.class)
	public ModelAndView handleExceptions(InsufficientFundsException e) {
		return controller.errorDisplay(e.error(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(TimeoutForCancelException.class)
	public ModelAndView handleExceptions(TimeoutForCancelException e) {
		return controller.errorDisplay(e.error(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(WrongInputInfoException.class)
	public ModelAndView handleExceptions(WrongInputInfoException e) {
		return controller.errorDisplay(e.error(), HttpStatus.BAD_REQUEST);
	}
}
