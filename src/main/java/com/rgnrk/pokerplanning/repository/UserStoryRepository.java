package com.rgnrk.pokerplanning.repository;

import com.rgnrk.pokerplanning.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, String> {
}
