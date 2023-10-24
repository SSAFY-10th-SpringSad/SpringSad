package com.spring.sad.global.exception.dto;

import com.spring.sad.global.exception.SadException;
import lombok.*;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Builder
public class SadExceptionResponse {
    private String message;
    private String errorCode;

    public static ResponseEntity<SadExceptionResponse> toResponse(SadException e) {
        return ResponseEntity
                .status(e.getStatusCode())
                .body(SadExceptionResponse.builder()
                        .errorCode(e.getErrorCode())
                        .message(e.getMessage())
                        .build()
                );
    }
}
