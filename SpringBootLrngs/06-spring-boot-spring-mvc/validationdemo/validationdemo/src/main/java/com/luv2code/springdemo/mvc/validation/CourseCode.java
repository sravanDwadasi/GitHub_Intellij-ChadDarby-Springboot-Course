package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//CourseCodeConstraintValidator.class is the helper class that contains business rules/validation logic
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
//The target annotation tells us where we can apply our annotation to a method or field, etc..........
@Target({ElementType.METHOD, ElementType.FIELD})
//The Retention annotation basically tells us up to when we need to retain this annotation and when to process it.
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "LUV";

    // define default error message
    public String message() default "must start with LUV";

    // define default groups
    public Class<?>[] groups() default{};

    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}
