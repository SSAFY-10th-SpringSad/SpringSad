package com.spring.sad.global.exception;

import com.spring.sad.global.exception.dto.GlobalExceptionResponse;
import com.spring.sad.global.exception.dto.ValidationExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<GlobalExceptionResponse> globalHandlerException(GlobalException e) {
        return GlobalExceptionResponse.toResponse(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponse> validationHandlerException(MethodArgumentNotValidException e) {
        return ValidationExceptionResponse.toResponse(e);
    }
}
