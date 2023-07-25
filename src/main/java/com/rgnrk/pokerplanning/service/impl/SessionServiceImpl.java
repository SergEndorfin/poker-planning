package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.exception.SessionNotFoundException;
import com.rgnrk.pokerplanning.repository.SessionRepository;
import com.rgnrk.pokerplanning.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session getSessionById(Long sessionId) {
        return sessionRepository
                .findSessionWithUsersAndUserStories(sessionId)
                .orElseThrow(() -> new SessionNotFoundException(sessionId));
    }

    @Override
    public void destroySession(Long sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
