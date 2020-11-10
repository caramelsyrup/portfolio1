package com.mysql.pro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysql.pro.domain.Userinfo;

public interface UserRepository extends JpaRepository<Userinfo, Long> {
	// account를 통해 화원을 조회할 수 있도록
	Optional<Userinfo> findByAccount(String account);
}
