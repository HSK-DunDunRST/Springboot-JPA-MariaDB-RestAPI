package com.hsk.restapi.HSKSite.data.dtoSet;

import org.springframework.http.HttpStatus;

import com.hsk.restapi.HSKSite.common.ErrorResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponseDTO<T> {
    private HttpStatus status;
    private T data;
    private ErrorResponse error;
    
    @Builder
    private ApiResponseDTO(HttpStatus status, T data, ErrorResponse error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }
}
