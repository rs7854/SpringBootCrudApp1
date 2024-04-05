package com.example.crudapp2.crudappdemo.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.crudapp2.crudappdemo.Entity.ErrorDto;
import com.example.crudapp2.crudappdemo.Exception.ProductNotFoundException;

@ControllerAdvice
public class ProductExceptionHandler {

	@ResponseBody
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorDto handleException(ProductNotFoundException ex) {
		return ErrorDto.builder()
					.status("Product not Available ! sorry for Inconvinience")
					.errorMessage(ex.getMessage())
					.statusCode(HttpStatus.OK).build();
	}
	
	
//	@ExceptionHandler(ProductNotFoundException.class)
//	public ProblemDetail handleException2(ProductNotFoundException ex) {
//		return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//	}
	
}
