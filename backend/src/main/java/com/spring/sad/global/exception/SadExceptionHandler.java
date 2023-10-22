package com.spring.sad.global.exception;

import com.spring.sad.global.exception.dto.SadExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SadExceptionHandler {
    @ExceptionHandler(SadException.class)
    public ResponseEntity<SadExceptionResponse> handlerException(SadException e) {
        return SadExceptionResponse.of(e);
    }
}
