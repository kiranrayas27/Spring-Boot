
package com.msedcl.main.customer.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@Override
	protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> allErrors=ex.getAllErrors();
		Map<String, String> fieldErrorMap=new HashMap<>();
		
		for(ObjectError objectError : allErrors) {
			FieldError fieldError=(FieldError)objectError;
			fieldErrorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrorMap);
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ProblemDetail>handleCustomerNotFoundException(CustomerNotFoundException ex){
		ProblemDetail problemDetail=ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
		problemDetail.setDetail(ex.getMessage());
		problemDetail.setTitle("CUSTOMER_NOT_FOUND");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
	}
}
