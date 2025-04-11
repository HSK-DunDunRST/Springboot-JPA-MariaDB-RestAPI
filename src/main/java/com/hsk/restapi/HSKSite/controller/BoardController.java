package com.hsk.restapi.HSKSite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsk.restapi.HSKSite.data.dtoSet.ApiResponseDTO;
import com.hsk.restapi.HSKSite.data.dtoSet.BoardRequestDTO;
import com.hsk.restapi.HSKSite.data.dtoSet.BoardResponseDTO;
import com.hsk.restapi.HSKSite.data.entitySet.BoardEntity;
import com.hsk.restapi.HSKSite.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @GetMapping
    public ApiResponseDTO<Optional<BoardEntity>> getByBoardId(@RequestParam(name = "id") Long id){
        return boardService.getByIdBoard(id);
    }

    @GetMapping("/list")
    public ApiResponseDTO<List<BoardResponseDTO>> getBoardList(){
        return boardService.getBoard();
    }

    @PostMapping("/create")
    public ApiResponseDTO<BoardResponseDTO> createBoard(@RequestBody BoardRequestDTO boardRequestDTO){
        return boardService.createBoard(boardRequestDTO);
    }
}
