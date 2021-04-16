package com.exampleteste.trabalhoteste.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exampleteste.trabalhoteste.services.exceptions.DatabaseException;
import com.exampleteste.trabalhoteste.services.exceptions.SaleNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(SaleNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(SaleNotFoundException e, HttpServletRequest request) {
		String error = "Venda não encontrada";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
