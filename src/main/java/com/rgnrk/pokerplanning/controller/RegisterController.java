package com.rgnrk.pokerplanning.controller;

import com.rgnrk.pokerplanning.dto.security.UserDto;
import com.rgnrk.pokerplanning.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.rgnrk.pokerplanning.constant.TemplateConstant.*;

@Controller
@RequestMapping(("/register"))
@AllArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping
    public String showLoginPage() {
        return "register";
    }

    @PostMapping
    public String processRegistration(UserDto userDto, Model model, RedirectAttributes redirectAttributes) {
        var registeredUser = registerService.register(userDto);
        if (registeredUser.isPresent()) {
            redirectAttributes.addFlashAttribute(SUCCESS_MSG_ATR, SUCCESS_MSG);
            return "redirect:/login";
        } else {
            model.addAttribute(ERROR_MSG_ATR, ERROR_MSG);
            return "register";
        }
    }
}
