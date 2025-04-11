package com.hsk.restapi.HSKSite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsk.restapi.HSKSite.common.ErrorResponse;
import com.hsk.restapi.HSKSite.common.ResponseUtils;
import com.hsk.restapi.HSKSite.data.dtoSet.ApiResponseDTO;
import com.hsk.restapi.HSKSite.data.dtoSet.BoardRequestDTO;
import com.hsk.restapi.HSKSite.data.dtoSet.BoardResponseDTO;
import com.hsk.restapi.HSKSite.data.entitySet.BoardEntity;
import com.hsk.restapi.HSKSite.data.enumSet.ErrorType;
import com.hsk.restapi.HSKSite.repository.BoardEntityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private final BoardEntityRepository boardEntityRepository;

    @Transactional(readOnly = true)
    public ApiResponseDTO<List<BoardResponseDTO>> getBoard(){
        List<BoardEntity> boardList = boardEntityRepository.findAll();
        List<BoardResponseDTO> boardResponseList = new ArrayList<>();

        for(BoardEntity boardEntity : boardList){
            boardResponseList.add(BoardResponseDTO.from(boardEntity));
        }
        return ResponseUtils.success(boardResponseList);
    }

    @Transactional
    public ApiResponseDTO<BoardResponseDTO> createBoard(BoardRequestDTO boardRequestDTO){
        if(boardEntityRepository.findByBoardTableName(boardRequestDTO.getBoardTableName()).isEmpty()){
            BoardEntity savedBoard = boardEntityRepository.save(BoardEntity.of(boardRequestDTO));
            //* Debugging 전용 출력문
            System.out.println("Saved Board ID: " + savedBoard.getId());
            return ResponseUtils.success(BoardResponseDTO.from(savedBoard));
        } else {
            return ResponseUtils.error(ErrorResponse.of(ErrorType.DUPLICATE_BOARDNAME, "이미 존재하는 게시판입니다."));
        }
    }

    @Transactional
    public ApiResponseDTO<Optional<BoardEntity>> getByIdBoard(Long id){
        if(boardEntityRepository.findById(id).isPresent()){
            return ResponseUtils.success(boardEntityRepository.findById(id));
        } else {
            return ResponseUtils.error(ErrorResponse.of(ErrorType.NOT_FOUND_BOARD, "게시판을 찾을 수 없습니다."));
        }
    }
}
