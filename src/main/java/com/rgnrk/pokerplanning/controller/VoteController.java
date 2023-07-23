package com.rgnrk.pokerplanning.controller;

import com.rgnrk.pokerplanning.entity.Vote;
import com.rgnrk.pokerplanning.service.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
@AllArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public Vote addVote(@RequestBody Vote vote) {
        return null;
    }

    @GetMapping("/user-story/{userStoryId}")
    public List<Vote> getVotesByUserStoryId(@PathVariable Long userStoryId) {
        return null;
    }
}

