package com.spring.sad.member.exception;

import com.spring.sad.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum MemberErrorCode implements ErrorCode {
    DUPLICATE_EMAIL(400, "DUPLICATE_EMAIL", "해당 이메일로 이미 가입된 계정이 있습니다."),
    DUPLICATE_PHONE_NUMBER(400, "DUPLICATE_PHONE_NUMBER", "해당 핸드폰 번호로 이미 가입된 계정이 있습니다."),
    INVALID_EMAIL_FORMAT(400, "INVALID_EMAIL_FORMAT", "잘못된 이메일 형식입니다."),
    INVALID_PHONE_NUMBER_FORMAT(400, "INVALID_PHONE_NUMBER", "잘못된 핸드폰 번호 형식입니다."),
    INVALID_DATE_FORMAT(400, "INVALID_DATE_FORMAT", "잘못된 날짜 형식입니다."),
    LOGIN_FAILED(400, "LOGIN_FAILED", "존재하지 않는 계정이거나 틀린 비밀번호를 입력하였습니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    MemberErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
