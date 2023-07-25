package com.rgnrk.pokerplanning.controller;

import com.rgnrk.pokerplanning.service.VoteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.rgnrk.pokerplanning.constant.TemplateConstant.PLANING_SESSION_ATR;
import static com.rgnrk.pokerplanning.constant.TemplateConstant.USER_STORY_ID_ATR;

@Controller
@RequestMapping("/votes")
@AllArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public String addVote(
            @RequestParam String grade,
            @RequestParam(USER_STORY_ID_ATR) String userStoryId,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes
    ) {
        var session = voteService.addVote(grade, userStoryId, request.getSession());
        redirectAttributes.addFlashAttribute(PLANING_SESSION_ATR, session);
        return "redirect:/sessions/" + session.getId();
    }
}

