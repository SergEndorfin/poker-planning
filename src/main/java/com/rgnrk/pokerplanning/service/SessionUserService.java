package com.rgnrk.pokerplanning.service;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.SessionUser;

public interface SessionUserService {

    Session addSessionUser(SessionUser user, Long sessionId);
}
