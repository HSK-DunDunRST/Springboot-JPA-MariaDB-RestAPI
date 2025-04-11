package com.hsk.restapi.HSKSite.repository;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class DynamicRepository {
    
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    // 동적 테이블 - 게시판 생성
    public void createDynamicBoard(String boardTableName) throws SQLException{

    }

}
