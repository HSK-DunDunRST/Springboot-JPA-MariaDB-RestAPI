package com.hsk.restapi.HSKSite.data.enumSet;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorType {

    // Error Code - 400
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    DUPLICATE_USERID(HttpStatus.BAD_REQUEST, "이미 존재하는 아이디입니다."),
    DUPLICATE_BOARDNAME(HttpStatus.BAD_REQUEST, "이미 존재하는 게시판 이름입니다."),
    // Error code - 401
    NOT_WRITER(HttpStatus.UNAUTHORIZED, "작성자만 수정 및 삭제가 가능합니다."),
    NOT_VALID_TOKEN(HttpStatus.FORBIDDEN, "토근이 유효하지 않습니다."),
    // Error code - 404
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "해당 유저를 찾을 수 없습니다."),
    NOT_FOUND_BOARD(HttpStatus.NOT_FOUND, "해당 게시판을 찾을 수 없습니다."),
    NOT_FOUND_POST(HttpStatus.NOT_FOUND, "해당 게시글을 찾을 수 없습니다."),
    NOT_FOUND_FILE(HttpStatus.NOT_FOUND, "해당 파일을 찾을 수 없습니다."),
    // Error code - 500
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");

    private HttpStatus errorCode;
    private String errorMessage;

    ErrorType(HttpStatus errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
