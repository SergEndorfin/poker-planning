package com.rgnrk.pokerplanning.controller;

import com.rgnrk.pokerplanning.dto.UserDto;
import com.rgnrk.pokerplanning.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.rgnrk.pokerplanning.constant.TemplateConstant.LOGGED_IN_USER_ATR;

@Controller
@RequestMapping("login")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    @PostMapping
    public String processLogin(UserDto userDto, HttpSession session) {
        session.setAttribute(LOGGED_IN_USER_ATR, loginService.login(userDto));
        return "index";
    }
}
