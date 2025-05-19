package com.Amarachi._DaysChallenge.api.dto;

import java.time.LocalDateTime;

public class PostDto {
    private Long id;
    private String content;
    private String imageUrl;
    private LocalDateTime createdAt;
    private Long userId; // Who posted it

    // Constructor with id and content only (or other relevant fields if needed)
    public PostDto(Long id, String content, String imageUrl, String username) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        // For username, you can set it based on the User (it can be fetched in the service method)
        // But for now, we'll just assume the username is provided.
    }

    // Constructor to initialize PostDto with id, content, imageUrl, createdAt, and userId
    public PostDto(Long id, String content, String imageUrl, LocalDateTime createdAt, Long userId) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    // Getters and setters
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}



