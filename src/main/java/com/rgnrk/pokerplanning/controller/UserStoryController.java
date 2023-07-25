package com.rgnrk.pokerplanning.controller;

import com.rgnrk.pokerplanning.entity.UserStory;
import com.rgnrk.pokerplanning.service.UserStoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.rgnrk.pokerplanning.constant.TemplateConstant.PLANING_SESSION_ATR;
import static com.rgnrk.pokerplanning.constant.TemplateConstant.SESSION_ID_ATR;

@Controller
@RequestMapping("/user-stories")
@AllArgsConstructor
public class UserStoryController {

    private final UserStoryService userStoryService;

    @PostMapping
    public String addUserStory(@ModelAttribute UserStory userStory,
                               @RequestParam(SESSION_ID_ATR) Long sessionId,
                               RedirectAttributes redirectAttributes) {
        var session = userStoryService.create(userStory, sessionId);
        redirectAttributes.addFlashAttribute(PLANING_SESSION_ATR, session);
        return "redirect:/sessions/" + sessionId;
    }

    @DeleteMapping("/{userStoryId}")
    public String deleteUserStory(@PathVariable String userStoryId,
                                  @RequestParam(SESSION_ID_ATR) Long sessionId) {
        userStoryService.deleteUserStory(userStoryId);
        return "redirect:/sessions/" + sessionId;
    }

    @PutMapping("/{userStoryId}")
    public String switchStatus(@PathVariable String userStoryId,
                               @RequestParam(SESSION_ID_ATR) Long sessionId) {
        userStoryService.switchStatus(userStoryId);
        return "redirect:/sessions/" + sessionId;
    }
}
