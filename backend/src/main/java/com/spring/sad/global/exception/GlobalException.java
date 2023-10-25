package com.spring.sad.global.exception;

import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {
    private final int statusCode;
    private final String errorCode;
    private final String message;

    public GlobalException(ErrorCode errorCode) {
        this.statusCode = errorCode.getStatusCode();
        this.errorCode = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }
}