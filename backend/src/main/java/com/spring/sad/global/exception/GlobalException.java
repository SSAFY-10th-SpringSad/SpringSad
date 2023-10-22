package com.spring.sad.global.exception;

import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {
    private final int statusCode;
    private final String errorCode;
    private final String message;

    public GlobalException(ErrorCode code) {
        this.statusCode = code.getStatusCode();
        this.errorCode = code.getErrorCode();
        this.message = code.getMessage();
    }
}
