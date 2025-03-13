package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theconstraintValidatorContext) {

        // This is the validation logic which tests if the form data starts with our course prefix.
        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }else result = true;

        return result;
    }
}
