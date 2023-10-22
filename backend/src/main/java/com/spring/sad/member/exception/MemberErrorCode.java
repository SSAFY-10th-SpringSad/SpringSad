package com.spring.sad.member.exception;

import com.spring.sad.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum MemberErrorCode implements ErrorCode {
    EMAIL_IS_NOT_VALID(400, "MEMBER_01", "유효하지 않은 이메일 형식입니다."),
    BIRTH_DATE_YEAR_IS_NOT_VALID(400, "MEMBER_02", "유효하지 않은 생일 형식입니다.(년도)"),
    BIRTH_DATE_MONTH_IS_NOT_VALID(400, "MEMBER_03", "유효하지 않은 생일 형식입니다.(월)"),
    BIRTH_DATE_DAY_IS_NOT_VALID(400, "MEMBER_04", "유효하지 않은 생일 형식입니다.(일)");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    MemberErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
