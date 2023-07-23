package com.rgnrk.pokerplanning.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "tbl_session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String deckType;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private Set<SessionUser> users = new HashSet<>();

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private Set<UserStory> userStories = new HashSet<>();
}
