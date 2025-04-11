package com.hsk.restapi.HSKSite.common;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.hsk.restapi.HSKSite.data.enumSet.ErrorType;

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

    public static ErrorResponse of(ErrorType errorType){
        return ErrorResponse.builder()
                .status(errorType.getErrorCode().value())
                .message(errorType.getErrorMessage())
                .build();
    }
    
    public static ErrorResponse of(ErrorType errorType, String message) {
        return ErrorResponse.builder()
                .status(errorType.getErrorCode().value())
                .message(message)
                .build();
    }

    public static ErrorResponse of(BindingResult bindingResult){
        String message = "";

        if(bindingResult.hasErrors()) {
            message = bindingResult.getFieldErrors().get(0).getDefaultMessage();
        }
        return ErrorResponse.of(ErrorType.BAD_REQUEST, message);
    }
}
