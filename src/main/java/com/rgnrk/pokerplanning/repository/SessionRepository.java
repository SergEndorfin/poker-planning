package com.rgnrk.pokerplanning.repository;

import com.rgnrk.pokerplanning.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query("SELECT DISTINCT s FROM tbl_session s " +
            "LEFT JOIN FETCH s.users " +
            "LEFT JOIN FETCH s.userStories us " +
            "LEFT JOIN FETCH us.votes " +
            "WHERE s.id = :sessionId")
    Optional<Session> findSessionWithUsersAndUserStories(@Param("sessionId") Long sessionId);
}
