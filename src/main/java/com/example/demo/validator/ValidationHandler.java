package com.example.demo.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.CustomerNotFoundException;
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers,HttpStatus status,WebRequest request){
	
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName, message);
			
		});
		return new ResponseEntity<Object> (errors,HttpStatus.BAD_REQUEST);
	}
	
	
	  @ExceptionHandler(CustomerNotFoundException.class) public
	  ResponseEntity<String>
	  handleCustomerNotFoundException(CustomerNotFoundException
	  customerNotFoundException) { return new
	  ResponseEntity<String>("customer id is not found in database",HttpStatus.BAD_REQUEST);
	  }
	 
	  
	/*
	 * @ExceptionHandler(NoSuchElementException.class) public ResponseEntity<String>
	 * handleNoSuchElementException(NoSuchElementException noSuchElementException) {
	 * return new
	 * ResponseEntity<String>("No Value is found in Database,so check the request "
	 * ,HttpStatus.BAD_REQUEST); }
	 */
	 
}

