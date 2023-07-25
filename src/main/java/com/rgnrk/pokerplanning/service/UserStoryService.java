package com.rgnrk.pokerplanning.service;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.UserStory;

public interface UserStoryService {
    Session create(UserStory userStory, Long sessionId);

    void deleteUserStory(String id);

    void switchStatus(String id);
}
