package com.mysql.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysql.pro.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
