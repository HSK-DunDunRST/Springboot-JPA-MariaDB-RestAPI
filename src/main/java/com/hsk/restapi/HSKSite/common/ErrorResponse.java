package com.hsk.restapi.HSKSite.common;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private int status;
    private String message;

    @Builder
    private ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ErrorResponse of(int status, String message) {
        return ErrorResponse.builder()
                .status(status)
                .message(message)
                .build();
    }

    
}
