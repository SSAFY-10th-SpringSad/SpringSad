package com.spring.sad.global.exception;

import com.spring.sad.global.exception.dto.SadExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler(SadException.class)
    public ResponseEntity<SadExceptionResponse> sadHandlerException(SadException e) {
        return SadExceptionResponse.toResponse(e);
    }
}
