package com.hsk.restapi.HSKSite.data.enumSet;

import lombok.Getter;

@Getter
public enum ErrorType {

    NOT_VALID_TOKEN(400, "토근이 유효하지 않습니다."),
    NOT_WRITER(400, "작성자만 수정 및 삭제가 가능합니다."),
    NOT_FOUND_USER(400, "해당 유저를 찾을 수 없습니다."),
    NOT_FOUND_BOARD(400, "해당 게시판을 찾을 수 없습니다."),
    NOT_FOUND_POST(400, "해당 게시글을 찾을 수 없습니다."),
    NOT_FOUND_FILE(400, "해당 파일을 찾을 수 없습니다."),
    DUPLICATE_USERID(400, "이미 존재하는 아이디입니다.");

    private int errorCode;
    private String errorMessage;

    ErrorType(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
