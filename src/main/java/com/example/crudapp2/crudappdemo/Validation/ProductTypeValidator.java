package com.example.crudapp2.crudappdemo.Validation;

import java.util.Arrays;
import java.util.List;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductTypeValidator implements ConstraintValidator<ValidateProductType, String>{

	@Override
	public boolean isValid(String productType, ConstraintValidatorContext constraintValidatorContext) {
		List<String> productList = Arrays.asList("Electronics","Education"); 
		return productList.contains(productType);
	}

}
