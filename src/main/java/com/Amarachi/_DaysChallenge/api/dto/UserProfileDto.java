package com.Amarachi._DaysChallenge.api.dto;

public class UserProfileDto extends AuthRequest {
    private Long id;
    private String bio;
    private String profilePictureUrl;

    public UserProfileDto() {
    }

    public UserProfileDto(Long id, String username, String password, String bio, String profilePictureUrl) {
        super(username, password); // calls AuthRequest constructor
        this.id = id;
        this.bio = bio;
        this.profilePictureUrl = profilePictureUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}



