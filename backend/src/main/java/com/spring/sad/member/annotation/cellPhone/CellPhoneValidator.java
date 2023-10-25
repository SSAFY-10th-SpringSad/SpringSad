package com.spring.sad.member.annotation.cellPhone;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class CellPhoneValidator implements ConstraintValidator<ValidCellPhone, String> {
    private static final String CELL_PHONE_NUMBER_FORMAT = "^010\\d{8}$\n";
    private static final Pattern CELL_PHONE_NUMBER_PATTERN = Pattern.compile(CELL_PHONE_NUMBER_FORMAT);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            return !CELL_PHONE_NUMBER_PATTERN.matcher(value).matches();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
