package com.spring.sad.member.annotation.birthdate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BirthdateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBirthdate {
    String message() default "유효하지 않은 생년월일 형식입니다.";
    // TODO 에러 코드, 메시지 보내기
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
