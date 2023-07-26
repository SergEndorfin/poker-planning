package com.rgnrk.pokerplanning.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@Entity(name = "tbl_user_story")
public class UserStory implements Comparable<UserStory> {

    @Id
    private String id;
    private String description;

    @Enumerated(EnumType.STRING)
    private UserStoryStatus status = UserStoryStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.ALL)
    private Set<Vote> votes = new TreeSet<>(Comparator.comparingLong(Vote::getId));

    @Override
    public int compareTo(UserStory other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStory userStory = (UserStory) o;
        return id.equals(userStory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
