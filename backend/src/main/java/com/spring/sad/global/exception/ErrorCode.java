package com.spring.sad.global.exception;

public interface ErrorCode {
    int getStatusCode();
    String getErrorCode();
    String getMessage();
}
