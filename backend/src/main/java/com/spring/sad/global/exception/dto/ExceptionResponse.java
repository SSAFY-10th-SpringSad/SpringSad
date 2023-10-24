package com.spring.sad.global.exception.dto;

import com.spring.sad.global.exception.GlobalException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
public class ExceptionResponse {
    private String message;
    private String errorCode;

    public static ExceptionResponse from(GlobalException e){
        return new ExceptionResponse(e.getMessage(), e.getErrorCode());
    }
}
