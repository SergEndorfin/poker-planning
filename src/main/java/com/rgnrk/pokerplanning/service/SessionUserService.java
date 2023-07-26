package com.rgnrk.pokerplanning.service;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.SessionUser;
import jakarta.servlet.http.HttpSession;

public interface SessionUserService {

    Session addSessionUser(SessionUser user, Long sessionId, HttpSession httpSession);

    boolean isUsernameNotUnique(String username, Long sessionId);
}
