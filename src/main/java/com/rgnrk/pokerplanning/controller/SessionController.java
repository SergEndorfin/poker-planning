package com.rgnrk.pokerplanning.controller;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.SessionUser;
import com.rgnrk.pokerplanning.service.SessionService;
import com.rgnrk.pokerplanning.service.SessionUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

import static com.rgnrk.pokerplanning.constant.TemplateConstant.*;

@Controller
@RequestMapping("sessions")
@AllArgsConstructor
public class SessionController {

    private final SessionService sessionService;
    private final SessionUserService userService;

    @GetMapping({"create", "join"})
    public String showCreateSessionForm() {
        return "create_join_session";
    }

    @PostMapping
    public String createSession(@ModelAttribute Session planingSession,
                                Model model) {
        var createdSession = sessionService.createSession(planingSession);
        model.addAttribute(SESSION_ID_ATR, createdSession.getId());
        model.addAttribute(SESSION_CREATED_MSG_ATR, SESSION_CREATED_MSG);
        return "create_join_session";
    }

    @PostMapping("{sessionId}")
    public String joinSession(@ModelAttribute SessionUser user,
                              @PathVariable Long sessionId,
                              RedirectAttributes redirectAttributes) {
        var session = userService.addSessionUser(user, sessionId);
        redirectAttributes.addFlashAttribute(PLANING_SESSION_ATR, session);
        return "redirect:/sessions/" + sessionId;
    }

    @GetMapping("{sessionId}")
    public String viewSession(@PathVariable Long sessionId,
                              Model model,
                              HttpServletRequest request,
                              RedirectAttributes redirectAttributes) {
        if (isNewUser(request.getParameter("join"))) {
            redirectAttributes.addFlashAttribute(SESSION_ID_ATR, sessionId);
            return "redirect:/sessions/join";
        }
        var session = model.getAttribute(PLANING_SESSION_ATR);

        if (Objects.isNull(session)) {
            session = sessionService.getSessionById(sessionId);
        }
        model.addAttribute(PLANING_SESSION_ATR, session);
        model.addAttribute(INVITE_URL_ATR, request.getRequestURL().append("?join=new"));
        return "view_session";
    }

    @DeleteMapping("{sessionId}")
    public String destroySession(@PathVariable Long sessionId) {
        sessionService.destroySession(sessionId);
        //TODO: redirect to a confirmation page...
        return "redirect:/";
    }

    private static boolean isNewUser(String paramValue) {
        return "new".equals(paramValue);
    }
}