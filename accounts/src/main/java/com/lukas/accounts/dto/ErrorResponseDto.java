package com.lukas.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
@Data @AllArgsConstructor @Builder
public class ErrorResponseDto {
    @Schema(
            description = "API path invoked by a client"
    )
    private String apiPath;
    @Schema(
            description = "Error code representing the error happened"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "Error message representing the error happened"
    )
    private String errorMessage;
    @Schema(
            description = "Time representing the error happened"
    )
    private LocalDateTime errorTime;

}
