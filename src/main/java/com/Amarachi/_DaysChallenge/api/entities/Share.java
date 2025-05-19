package com.Amarachi._DaysChallenge.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shares")
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime sharedAt;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore  // 🚫 Prevents endless Post ↔ Share loop
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore  // 🚫 Prevents endless User ↔ Share loop
    private User user;

    public Share() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDateTime getSharedAt() {
        return sharedAt;
    }

    public Post getPost() {
        return post;
    }

    public User getUser() {
        return user;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSharedAt(LocalDateTime sharedAt) {
        this.sharedAt = sharedAt;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



