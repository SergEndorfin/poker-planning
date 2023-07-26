package com.rgnrk.pokerplanning.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity(name = "tbl_vote")
public class Vote implements Comparable<Vote> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String grade;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SessionUser user;

    @ManyToOne
    @JoinColumn(name = "user_story_id")
    private UserStory userStory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return id.equals(vote.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Vote other) {
        return Long.compare(this.id, other.id);
    }
}
