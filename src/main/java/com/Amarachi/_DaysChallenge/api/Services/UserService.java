package com.Amarachi._DaysChallenge.api.Services;


import com.Amarachi._DaysChallenge.api.dto.AuthRequest;
import com.Amarachi._DaysChallenge.api.dto.AuthResponse;
import com.Amarachi._DaysChallenge.api.dto.UserProfileDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    // 1. REGISTER
    AuthResponse register(AuthRequest authRequest);

    // 2. LOGIN
    AuthResponse login(UserProfileDto authRequest);

    UserProfileDto createUser(UserProfileDto userProfileDto);
    UserProfileDto getUserById(Long id);
    UserProfileDto updateUser(Long id, UserProfileDto userProfileDto);
    void deleteUser(Long id);

//    UserDetails loadUserByUsername(String username);
}
