package com.spring.sad.member.exception;

import com.spring.sad.global.exception.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MemberErrorCode implements ErrorCode {
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST.value(), "DUPLICATE_EMAIL", "이미 가입된 이메일입니다."),
    DUPLICATE_PHONE_NUMBER(HttpStatus.BAD_REQUEST.value(), "DUPLICATE_PHONE_NUMBER", "이미 가입된 핸드폰 번호입니다."),
    INVALID_EMAIL_FORMAT(HttpStatus.BAD_REQUEST.value(), "INVALID_EMAIL_FORMAT", "잘못된 이메일 형식입니다."),
    INVALID_CELL_PHONE_FORMAT(HttpStatus.BAD_REQUEST.value(), "INVALID_PHONE_NUMBER_FORMAT", "잘못된 핸드폰 번호 형식입니다."),
    INVALID_DATE_FORMAT(HttpStatus.BAD_REQUEST.value(), "INVALID_DATE_FORMAT", "잘못된 날짜 형식입니다."),
    LOGIN_FAILED(HttpStatus.BAD_REQUEST.value(), "LOGIN_FAILED", "로그인 정보를 확인해주세요.");

    private final int statusCode;
    private final String errorCode;
    private String message;

    MemberErrorCode(int statusCode, String errorCode, String message){
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
