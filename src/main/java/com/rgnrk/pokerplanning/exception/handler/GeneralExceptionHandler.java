package com.rgnrk.pokerplanning.exception.handler;

import com.rgnrk.pokerplanning.exception.SessionNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.rgnrk.pokerplanning.constant.TemplateConstant.ERROR_MSG_ATR;
import static com.rgnrk.pokerplanning.constant.TemplateConstant.PLANNING_SESSION_CURRENT_USER_ATR;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleUnpredictedException(Exception ex, HttpServletRequest request) {
        var session = request.getSession();
        return clearHttpSessionAndSetErrorMessage(session, request,
                "An unexpected error occurred: " + ex.getMessage());
    }

    @ExceptionHandler(SessionNotFoundException.class)
    public String handleSessionNotFoundException(SessionNotFoundException ex, HttpServletRequest request) {
        var session = request.getSession();
        return clearHttpSessionAndSetErrorMessage(session, request, ex.getMessage());
    }

    private String clearHttpSessionAndSetErrorMessage(HttpSession session, HttpServletRequest request, String ex) {
        session.removeAttribute(PLANNING_SESSION_CURRENT_USER_ATR);
        request.setAttribute(ERROR_MSG_ATR, ex);
        return "error";
    }
}
