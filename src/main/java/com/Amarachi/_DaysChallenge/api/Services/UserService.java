package com.Amarachi._DaysChallenge.api.Services;


import com.Amarachi._DaysChallenge.api.dto.UserProfileDto;

public interface UserService {
    UserProfileDto createUser(UserProfileDto userProfileDto);
    UserProfileDto getUserById(Long id);
    UserProfileDto updateUser(Long id, UserProfileDto userProfileDto);
    void deleteUser(Long id);
}
