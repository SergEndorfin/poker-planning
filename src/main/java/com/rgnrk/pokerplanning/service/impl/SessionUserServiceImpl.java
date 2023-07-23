package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.SessionUser;
import com.rgnrk.pokerplanning.repository.SessionUserRepository;
import com.rgnrk.pokerplanning.service.SessionService;
import com.rgnrk.pokerplanning.service.SessionUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionUserServiceImpl implements SessionUserService {

    private final SessionUserRepository userRepository;
    private final SessionService sessionService;

    @Override
    public Session addSessionUser(SessionUser user, Long sessionId) {
        var session = sessionService.getSessionById(sessionId);
        user.setSession(session);
        var savedSessionUser = userRepository.save(user);
        session.getUsers().add(savedSessionUser);
        return session;
    }
}
