package com.hsk.restapi.HSKSite.data.dtoSet;

import com.hsk.restapi.HSKSite.common.ErrorResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponseDTO<T> {
    private boolean success;
    private T data;
    private ErrorResponse error;
    
    @Builder
    private ApiResponseDTO(boolean success, T data, ErrorResponse error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }
}
