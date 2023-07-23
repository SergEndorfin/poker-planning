package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.UserStory;
import com.rgnrk.pokerplanning.repository.UserStoryRepository;
import com.rgnrk.pokerplanning.service.SessionService;
import com.rgnrk.pokerplanning.service.UserStoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserStoryServiceImpl implements UserStoryService {

    private final UserStoryRepository userStoryRepository;
    private final SessionService sessionService;

    @Override
    public Session create(UserStory userStory, Long sessionId) {
        var session = sessionService.getSessionById(sessionId);
        userStory.setSession(session);
        var savedUserStory = userStoryRepository.save(userStory);
        session.getUserStories().add(savedUserStory);
        return session;
    }

    @Override
    public void deleteUserStory(String id) {
        userStoryRepository.deleteById(id);
    }
}
