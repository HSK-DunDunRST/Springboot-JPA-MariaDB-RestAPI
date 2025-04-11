package com.hsk.restapi.HSKSite.common;

import org.springframework.http.HttpStatus;
import com.hsk.restapi.HSKSite.data.dtoSet.ApiResponseDTO;
public class ResponseUtils {

    // Success response
    public static <T> ApiResponseDTO<T> success(T data) {
        return ApiResponseDTO.<T>builder()
                .status(HttpStatus.OK)
                .data(data)
                .build();
    }

    // Error response
    public static <T> ApiResponseDTO<T> error(ErrorResponse error) {
        return ApiResponseDTO.<T>builder()
                .status(HttpStatus.BAD_REQUEST)
                .error(error)
                .build();
    }
}
