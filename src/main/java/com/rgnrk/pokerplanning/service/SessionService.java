package com.rgnrk.pokerplanning.service;

import com.rgnrk.pokerplanning.entity.Session;

public interface SessionService {

    Session createSession(Session session);

    Session getSessionById(Long sessionId);

    void destroySession(Long sessionId);
}
