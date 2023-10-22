package com.spring.sad.global.exception;

import com.spring.sad.global.exception.dto.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ExceptionResponse> handleException(GlobalException e) {
        return ResponseEntity.status(e.getStatusCode()).body(ExceptionResponse.from(e));
    }
}
