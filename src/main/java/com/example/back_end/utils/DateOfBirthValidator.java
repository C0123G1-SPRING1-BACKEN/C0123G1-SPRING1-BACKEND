package com.example.back_end.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class DateOfBirthValidator implements ConstraintValidator<YearOldValid,String> {
    @Override
    public void initialize(YearOldValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDate birthday = LocalDate.parse(value);
            LocalDate now = LocalDate.now();
            Period period = Period.between(birthday, now);
            int age = period.getYears();
            return age >= 18 && age < 100;
        } catch (Exception e) {
            return false;
        }
    }
}
