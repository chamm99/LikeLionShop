package com.likelion.likelionshop.repository;

import com.likelion.likelionshop.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByEmail(String email);
}
