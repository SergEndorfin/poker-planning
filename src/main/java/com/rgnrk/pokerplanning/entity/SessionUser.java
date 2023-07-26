package com.rgnrk.pokerplanning.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "tbl_session_user")
public class SessionUser implements Comparable<SessionUser> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Override
    public int compareTo(SessionUser other) {
        return Long.compare(this.id, other.id);
    }
}

