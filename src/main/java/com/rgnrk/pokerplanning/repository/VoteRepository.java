package com.rgnrk.pokerplanning.repository;

import com.rgnrk.pokerplanning.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByUserIdAndUserStoryId(Long userId, String userStoryId);
}
