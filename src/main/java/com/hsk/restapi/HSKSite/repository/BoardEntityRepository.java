package com.hsk.restapi.HSKSite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsk.restapi.HSKSite.data.entitySet.BoardEntity;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findByBoardTableName(String boardTableName);
}
