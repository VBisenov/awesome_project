package com.example.awesome_project.repository;

import com.example.awesome_project.model.TokenDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<TokenDTO, UUID> {
    TokenDTO getTokenDTOByUserId(UUID id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
    value = "DELETE FROM token WHERE student_id = ?1")
    void deleteAllByStudentId(UUID id);
}
