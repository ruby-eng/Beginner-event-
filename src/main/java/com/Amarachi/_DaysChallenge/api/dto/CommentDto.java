package com.Amarachi._DaysChallenge.api.dto;

import java.time.LocalDateTime;

public class CommentDto {
    private Long id;
    private String content;
    private Long postId;
    private Long userId;
    private LocalDateTime createdAt;

    public CommentDto() {
    }

    public CommentDto(Long id, String content, Long postId, Long userId, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.postId = postId;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}





