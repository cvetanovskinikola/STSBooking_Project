package com.getaway.weekend.app.exception;


import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = RequestException.class)
	public ResponseEntity<Object> handleRequestException(RequestException e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		AppException ae = 
				new AppException(e.getMessage(),badRequest , ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(ae,badRequest);
	}
	@ExceptionHandler(value = InsufficientFundsException.class)
	public ResponseEntity<Object> handleFundsException(InsufficientFundsException e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		AppException ae =
				new AppException(e.getMessage(),badRequest , ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(ae,badRequest);
	}
	@ExceptionHandler(NoSpotsLeftForDestinationException.class)
	public ResponseEntity<Object> handleNoSpotsException(NoSpotsLeftForDestinationException e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		AppException ae =
				new AppException(e.getMessage(),badRequest , ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(ae,badRequest);
	}
	@ExceptionHandler(NoRoomsOfYourChoiceLeftException.class)
	public ResponseEntity<Object> handleNoRoomsException(NoRoomsOfYourChoiceLeftException e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		AppException ae =
				new AppException(e.getMessage(),badRequest , ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(ae,badRequest);
	}
	@ExceptionHandler(WrongInputInfoException.class)
	public ResponseEntity<Object> handleInputException(WrongInputInfoException e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		AppException ae =
				new AppException(e.getMessage(),badRequest , ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(ae,badRequest);
	}
	@ExceptionHandler(TimeoutForCancelException.class)
	public ResponseEntity<Object> handleTimeoutException(TimeoutForCancelException e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		AppException ae =
				new AppException(e.getMessage(),badRequest , ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(ae,badRequest);
	}
}
