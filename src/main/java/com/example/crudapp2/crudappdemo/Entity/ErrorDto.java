package com.example.crudapp2.crudappdemo.Entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

	private String status;
	private String errorMessage;
	private HttpStatus statusCode;
}
