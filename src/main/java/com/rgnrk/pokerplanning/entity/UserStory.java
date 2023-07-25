package com.rgnrk.pokerplanning.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "tbl_user_story")
public class UserStory {

    @Id
    private String id;
    private String description;

    @Enumerated(EnumType.STRING)
    private UserStoryStatus status = UserStoryStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.ALL)
    private Set<Vote> votes = new HashSet<>();
}
