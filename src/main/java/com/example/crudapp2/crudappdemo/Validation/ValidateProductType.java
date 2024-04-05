package com.example.crudapp2.crudappdemo.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductTypeValidator.class)
public @interface ValidateProductType {
	
	
	String message() default "Invalid productType !";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
