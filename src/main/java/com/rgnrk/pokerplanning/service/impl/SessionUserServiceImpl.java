package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.SessionUser;
import com.rgnrk.pokerplanning.repository.SessionUserRepository;
import com.rgnrk.pokerplanning.service.SessionService;
import com.rgnrk.pokerplanning.service.SessionUserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.rgnrk.pokerplanning.constant.TemplateConstant.PLANNING_SESSION_CURRENT_USER_ATR;

@Service
@AllArgsConstructor
public class SessionUserServiceImpl implements SessionUserService {

    private final SessionUserRepository userRepository;
    private final SessionService sessionService;

    @Override
    public Session addSessionUser(SessionUser user, Long sessionId, HttpSession httpSession) {
        var session = sessionService.getSessionById(sessionId);
        user.setSession(session);
        var savedSessionUser = userRepository.save(user);
        Set<SessionUser> users = session.getUsers();
        users.add(savedSessionUser);
        httpSession.setAttribute(PLANNING_SESSION_CURRENT_USER_ATR, savedSessionUser);
        return session;
    }
}
