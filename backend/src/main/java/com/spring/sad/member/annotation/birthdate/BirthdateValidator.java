package com.spring.sad.member.annotation.birthdate;

import com.spring.sad.member.data.vo.Birthdate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.DateTimeException;
import java.time.LocalDate;

public class BirthdateValidator implements ConstraintValidator<ValidBirthdate, Birthdate> {

    @Override
    public void initialize(ValidBirthdate constraintAnnotation) {
    }

    @Override
    public boolean isValid(Birthdate value, ConstraintValidatorContext context) {
        try {
            LocalDate.of(value.getYear(), value.getMonth(), value.getDay());
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
}
