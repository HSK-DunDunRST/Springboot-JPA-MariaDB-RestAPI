package com.hsk.restapi.HSKSite.data.dtoSet;

import java.time.LocalDateTime;

import com.hsk.restapi.HSKSite.data.entitySet.BoardEntity;

import lombok.Getter;

@Getter
public class BoardResponseDTO {
    private Long boardId;
    private String boardName;
    private String boardTableName;
    private String boardDescription;
    private LocalDateTime boardCreateDate;

    private BoardResponseDTO(BoardEntity boardEntity){
        this.boardId = boardEntity.getBoardId();
        this.boardName = boardEntity.getBoardName();
        this.boardTableName = boardEntity.getBoardTableName();
        this.boardDescription = boardEntity.getBoardDescription();
        this.boardCreateDate = boardEntity.getBoardCreateDate();
    }

    public static BoardResponseDTO from(BoardEntity boardEntity) {
        return new BoardResponseDTO(boardEntity);
    }
}
