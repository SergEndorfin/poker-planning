package com.rgnrk.pokerplanning.repository;

import com.rgnrk.pokerplanning.entity.SessionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionUserRepository extends JpaRepository<SessionUser, Long> {

    Optional<SessionUser> findByUsernameAndSessionId(String username, Long sessionId);
}
