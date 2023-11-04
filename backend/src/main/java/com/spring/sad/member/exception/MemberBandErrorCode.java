package com.spring.sad.member.exception;

import com.spring.sad.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum MemberBandErrorCode implements ErrorCode {
    INVALID_MEMBER_BAND_RELATIONSHIP(400, "MEMBER-BAND_01", "Member-Band 연관 관계가 유효하지 않습니다");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    MemberBandErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
