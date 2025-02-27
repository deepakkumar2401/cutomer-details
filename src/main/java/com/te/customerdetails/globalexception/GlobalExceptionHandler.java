package com.te.customerdetails.globalexception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.customerdetails.dto.ResponseDto;
import com.te.customerdetails.exception.DataFoundException;
import com.te.customerdetails.exception.DataNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataFoundException.class)
	public ResponseEntity<ResponseDto> dataFound(DataFoundException e) {
		return ResponseEntity.badRequest().body(new ResponseDto(true, e.getMessage(), null));
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseDto> dataNotFound(DataNotFoundException e) {
		return ((BodyBuilder) ResponseEntity.notFound()).body(new ResponseDto(true, e.getMessage(), null));
	}
}
