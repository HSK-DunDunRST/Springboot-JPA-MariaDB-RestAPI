package com.hsk.restapi.HSKSite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsk.restapi.HSKSite.common.ResponseUtils;
import com.hsk.restapi.HSKSite.data.dtoSet.ApiResponseDTO;
import com.hsk.restapi.HSKSite.data.dtoSet.BoardRequestDTO;
import com.hsk.restapi.HSKSite.data.dtoSet.BoardResponseDTO;
import com.hsk.restapi.HSKSite.data.entitySet.BoardEntity;
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
        BoardEntity savedBoard = boardEntityRepository.save(BoardEntity.of(boardRequestDTO));
        //* Debugging 전용 출력문
        System.out.println("Saved Board ID: " + savedBoard.getId());
        return ResponseUtils.success(BoardResponseDTO.from(savedBoard));
    }
}
