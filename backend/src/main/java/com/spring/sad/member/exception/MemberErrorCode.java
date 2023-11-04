package com.spring.sad.member.exception;

import com.spring.sad.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum MemberErrorCode implements ErrorCode {
    EMAIL_IS_NOT_VALID(400, "MEMBER_01", "유효하지 않은 이메일 형식입니다."),
    PHONE_NUMBER_IS_NOT_VALID(400, "MEMBER_02", "유효하지 않은 전화번호 형식입니다."),
    BIRTH_DATE_YEAR_IS_NOT_VALID(400, "MEMBER_03", "유효하지 않은 생년월일 형식입니다."),

    EMAIL_ALREADY_EXISTS(400, "MEMBER_04", "존재하는 이메일입니다."),
    PHONE_NUMBER_ALREADY_EXISTS(400, "MEMBER_05", "존재하는 전화번호입니다."),

    LOGIN_FAILED(400, "MEMBER_06", "아이디가 존재하지 않거나 잘못된 비밀 번호 입니다."),

    MEMBER_DOES_NOT_EXISTS(400, "MEMBER_07", "존재하지 않는 회원입니다.");


    private final int statusCode;
    private final String errorCode;
    private final String message;

    MemberErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
