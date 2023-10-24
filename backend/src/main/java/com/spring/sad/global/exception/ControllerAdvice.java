package com.spring.sad.global.exception;

import com.spring.sad.global.exception.dto.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //@RestController로 선언한 지점에서 발생한 에러를 catch해 처리해줌
public class ControllerAdvice {
    @ExceptionHandler(GlobalException.class) //특정 에러 발생 시 오류 반환하도록 처리
    public ResponseEntity<ExceptionResponse> handleException(GlobalException e){
        return ResponseEntity.status(e.getStatusCode()).body(ExceptionResponse.from(e));
    }
}
