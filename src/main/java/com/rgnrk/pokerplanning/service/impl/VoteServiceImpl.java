package com.rgnrk.pokerplanning.service.impl;

import com.rgnrk.pokerplanning.entity.Session;
import com.rgnrk.pokerplanning.entity.SessionUser;
import com.rgnrk.pokerplanning.entity.UserStory;
import com.rgnrk.pokerplanning.entity.Vote;
import com.rgnrk.pokerplanning.repository.VoteRepository;
import com.rgnrk.pokerplanning.service.SessionService;
import com.rgnrk.pokerplanning.service.VoteService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

import static com.rgnrk.pokerplanning.constant.TemplateConstant.PLANNING_SESSION_CURRENT_USER_ATR;

@Service
@AllArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    private final SessionService sessionService;
    private final Logger logger;

    @Override
    public Session addVote(String grade, String storyId, HttpSession httpSession) {
        var user = (SessionUser) httpSession.getAttribute(PLANNING_SESSION_CURRENT_USER_ATR);
        var session = sessionService.getSessionById(user.getSession().getId());
        session.getUserStories()
                .stream()
                .filter(story -> storyId.equals(story.getId()))
                .findAny()
                .ifPresent(createAndAddVote(grade, storyId, user));
        logger.debug("Vote created and added to Story with id: {}", storyId);
        return session;
    }

    private Consumer<UserStory> createAndAddVote(String grade, String storyId, SessionUser user) {
        return story -> {
            var vote = getVoteIfExistOrCreate(storyId, user.getId());
            vote.setGrade(grade);
            vote.setUser(user);
            vote.setUserStory(story);
            var savedVote = voteRepository.save(vote);
            story.getVotes().add(savedVote);
        };
    }

    private Vote getVoteIfExistOrCreate(String storyId, Long userId) {
        return this.voteRepository
                .findByUserIdAndUserStoryId(userId, storyId)
                .orElse(new Vote());
    }
}
