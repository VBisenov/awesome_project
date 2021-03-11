package com.example.awesome_project.repository;

import com.example.awesome_project.model.TokenDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenDTO, Long> {
    TokenDTO getTokenDTOByUserId(long id);
}
