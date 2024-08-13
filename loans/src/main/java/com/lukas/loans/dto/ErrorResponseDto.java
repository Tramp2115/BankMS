package com.lukas.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @Builder
public class ErrorResponseDto {
    private String apiPath;
    HttpStatus errorCode;
    private String errorMessage;
    private LocalDateTime errorTime;
}
