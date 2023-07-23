package com.rgnrk.pokerplanning.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
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
}
