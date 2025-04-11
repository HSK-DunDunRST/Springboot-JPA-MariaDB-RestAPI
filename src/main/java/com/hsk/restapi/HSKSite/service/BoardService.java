package com.hsk.restapi.HSKSite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.hsk.restapi.HSKSite.repository.DynamicRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private final BoardEntityRepository boardEntityRepository;

    @Autowired
    private final DynamicRepository dynamicRepository;

    @Transactional(readOnly = true)
    public ApiResponseDTO<List<BoardResponseDTO>> getBoard(){
        List<BoardEntity> boardList = boardEntityRepository.findAll();
        List<BoardResponseDTO> boardResponseList = new ArrayList<>();

        for(BoardEntity boardEntity : boardList){
            boardResponseList.add(BoardResponseDTO.from(boardEntity));
        }
        return ResponseUtils.success(boardResponseList);
    }

    // 게시판 생성
    @Transactional
    public ApiResponseDTO<BoardResponseDTO> createBoard(BoardRequestDTO boardRequestDTO){
        try{
            if(boardEntityRepository.findByBoardTableName(boardRequestDTO.getBoardTableName()).isEmpty()){
                dynamicRepository.createDynamicBoard(boardRequestDTO);
                BoardEntity savedBoard = boardEntityRepository.save(BoardEntity.of(boardRequestDTO));
                //* Debugging 전용 출력문
                System.out.println("Saved Board ID: " + savedBoard.getBoardId());
                return ResponseUtils.success(BoardResponseDTO.from(savedBoard));
            } else {
                return ResponseUtils.error(ErrorResponse.of(ErrorType.DUPLICATE_BOARDNAME, "이미 존재하는 게시판입니다."));
            }
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseUtils.error(ErrorResponse.of(ErrorType.INTERNAL_SERVER_ERROR, exception.getMessage()));
        }
    }

    // 특정 게시판 조회(with id)
    @Transactional
    public ApiResponseDTO<Optional<BoardEntity>> getByIdBoard(Long id){
        if(boardEntityRepository.findById(id).isPresent()){
            return ResponseUtils.success(boardEntityRepository.findById(id));
        } else {
            return ResponseUtils.error(ErrorResponse.of(ErrorType.NOT_FOUND_BOARD, "게시판을 찾을 수 없습니다."));
        }
    }
}
