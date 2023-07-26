package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.UserStory;
import com.rgnrk.pokerplanning.exception.SessionNotFoundException;
import com.rgnrk.pokerplanning.repository.SessionRepository;
import com.rgnrk.pokerplanning.service.SessionService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;

@Service
@AllArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final Logger logger;
    private final SessionRepository sessionRepository;

    @Override
    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session getSessionById(Long sessionId) {
        logger.debug("Retrieving Session by id.");
        return sessionRepository
                .findSessionWithUsersAndUserStories(sessionId)
                .map(session -> {
                    session.setUsers(new TreeSet<>(session.getUsers()));
                    session.setUserStories(new TreeSet<>(getStoriesWithSortedVotes(session)));
                    return session;
                })
                .orElseThrow(() -> new SessionNotFoundException(sessionId));
    }

    @Override
    public void destroySession(Long sessionId) {
        sessionRepository.deleteById(sessionId);
        logger.info("Session with id {} removed.", sessionId);
    }

    private List<UserStory> getStoriesWithSortedVotes(Session session) {
        return session.getUserStories()
                .stream()
                .peek(userStory -> userStory.setVotes(new TreeSet<>(userStory.getVotes())))
                .toList();
    }
}

