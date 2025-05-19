package com.Amarachi._DaysChallenge.api.controllers;

import com.Amarachi._DaysChallenge.api.Services.UserService;
import com.Amarachi._DaysChallenge.api.dto.AuthRequest;
import com.Amarachi._DaysChallenge.api.dto.AuthResponse;
import com.Amarachi._DaysChallenge.api.dto.UserProfileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserProfileDto dto) {
        AuthResponse token = userService.register(new AuthRequest(dto.getUsername(), dto.getPassword()));
        return ResponseEntity.ok("Token: " + token.getToken());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserProfileDto dto) {
        AuthResponse token = userService.login(dto);
        return ResponseEntity.ok("Token: " + token.getToken());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDto> getUserProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDto> updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }
}






