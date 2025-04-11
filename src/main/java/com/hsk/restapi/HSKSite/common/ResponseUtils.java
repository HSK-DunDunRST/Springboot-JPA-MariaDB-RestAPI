package com.hsk.restapi.HSKSite.common;

import com.hsk.restapi.HSKSite.data.dtoSet.ApiResponseDTO;

public class ResponseUtils {

    // Success response
    public static <T> ApiResponseDTO<T> success(T data) {
        return ApiResponseDTO.<T>builder()
                .success(true)
                .data(data)
                .build();
    }

    // Error response
    public static <T> ApiResponseDTO<T> error(ErrorResponse error) {
        return ApiResponseDTO.<T>builder()
                .success(false)
                .error(error)
                .build();
    }
}
