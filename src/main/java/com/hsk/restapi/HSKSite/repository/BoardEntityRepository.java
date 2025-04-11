package com.hsk.restapi.HSKSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsk.restapi.HSKSite.data.entitySet.BoardEntity;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity, Long> {

}
