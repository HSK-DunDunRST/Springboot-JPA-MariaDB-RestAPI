package com.hsk.restapi.HSKSite.repository;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hsk.restapi.HSKSite.data.dtoSet.BoardRequestDTO;
import com.hsk.restapi.HSKSite.data.dtoSet.PostRequestDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class DynamicRepository {
    
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    // 동적 테이블 - 게시판 생성
    public void createDynamicBoard(BoardRequestDTO boardRequestDTO) throws SQLException{
        try{
            String createTableQuery = String.format(
                "CREATE TABLE IF NOT EXISTS %s ("
                + "post_id BIGINT AUTO_INCREMENT PRIMARY KEY, "
                + "board_id BIGINT NOT NULL, "
                + "post_title VARCHAR(255) NOT NULL, "
                + "post_content TEXT NOT NULL, "
                + "post_writer VARCHAR(255) NOT NULL, "
                + "post_view_count INT DEFAULT 0, "
                + "is_notice BOOLEAN DEFAULT FALSE, "
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                + "FOREIGN KEY (board_id) REFERENCES board_data(board_id) ON DELETE CASCADE);",
                boardRequestDTO.getBoardTableName()
            );
            
            jdbcTemplate.execute(createTableQuery);
        } catch(Exception exception){
            exception.printStackTrace();
            throw new SQLException("[DynamicRepository] 게시판 테이블 생성 중 오류 발생: " + exception.getMessage());
        }
        
    }
}
