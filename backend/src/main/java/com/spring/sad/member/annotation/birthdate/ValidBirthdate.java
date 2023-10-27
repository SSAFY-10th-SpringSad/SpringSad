package com.spring.sad.member.annotation.birthdate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = BirthdateValidator.class)
@Target({METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ValidBirthdate {
    String message() default "유효하지 않은 생년월일 형식입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
