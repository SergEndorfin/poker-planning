package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.UserStory;
import com.rgnrk.pokerplanning.repository.UserStoryRepository;
import com.rgnrk.pokerplanning.service.SessionService;
import com.rgnrk.pokerplanning.service.UserStoryService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.rgnrk.pokerplanning.entity.UserStoryStatus.*;

@Service
@AllArgsConstructor
public class UserStoryServiceImpl implements UserStoryService {

    private final UserStoryRepository userStoryRepository;
    private final SessionService sessionService;
    private final Logger logger;

    @Override
    public Session create(UserStory userStory, Long sessionId) {
        var session = sessionService.getSessionById(sessionId);
        userStory.setSession(session);
        var savedUserStory = userStoryRepository.save(userStory);
        session.getUserStories().add(savedUserStory);
        logger.info("New Story {} created and added to Session {}", savedUserStory.getId(), session.getId());
        return session;
    }

    @Override
    public void deleteUserStory(String id) {
        userStoryRepository.deleteById(id);
    }

    @Override
    public void switchStatus(String id) {
        Optional<UserStory> foundUserStory = userStoryRepository.findById(id);
        foundUserStory.ifPresent(this::switchStatusAndSave);
    }

    private void switchStatusAndSave(UserStory userStory) {
        var status = userStory.getStatus().equals(PENDING) ? VOTING : VOTED;
        logger.debug("User Story {} status switched. Current status: {}", userStory.getId(), status);
        userStory.setStatus(status);
        userStoryRepository.save(userStory);
    }
}
