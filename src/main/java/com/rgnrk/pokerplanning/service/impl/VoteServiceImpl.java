package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.entity.Vote;
import com.rgnrk.pokerplanning.repository.VoteRepository;
import com.rgnrk.pokerplanning.service.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    public Vote addVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public List<Vote> getVotesByUserStoryId(String userStoryId) {
        return null;
    }
}
