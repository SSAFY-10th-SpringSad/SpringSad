package com.spring.sad.global.exception.dto;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Builder
public class MethodArgumentNotValidExceptionResponse {
    private String message;

    public static ResponseEntity<MethodArgumentNotValidExceptionResponse> toResponse(MethodArgumentNotValidException e) {
        return ResponseEntity
            .status(e.getStatusCode())
            .body(MethodArgumentNotValidExceptionResponse.builder()
                    .message(Objects.requireNonNull(
                            e.getBindingResult().getFieldError()
                            ).getDefaultMessage())
                    .build()
            );
    }
}
