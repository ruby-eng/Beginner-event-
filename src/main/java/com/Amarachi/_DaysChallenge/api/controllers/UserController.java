package com.Amarachi._DaysChallenge.api.controllers;


import com.Amarachi._DaysChallenge.api.Services.UserService;
import com.Amarachi._DaysChallenge.api.dto.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDto> getUserProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getProfile(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDto> updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDto userProfileDto) {
        return ResponseEntity.ok(userService.updateProfile(id, userProfileDto));
    }
}

