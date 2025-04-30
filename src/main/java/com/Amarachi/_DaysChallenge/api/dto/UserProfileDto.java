package com.Amarachi._DaysChallenge.api.dto;


import lombok.Data;

@Data
public class UserProfileDto {
    private Long id;
    private String username;
    private String bio;
    private String profilePictureUrl;
}

