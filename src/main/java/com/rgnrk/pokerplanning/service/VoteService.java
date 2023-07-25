package com.rgnrk.pokerplanning.service;

import com.rgnrk.pokerplanning.entity.Session;
import jakarta.servlet.http.HttpSession;

public interface VoteService {
    Session addVote(String grade, String userStoryId, HttpSession session);
}
