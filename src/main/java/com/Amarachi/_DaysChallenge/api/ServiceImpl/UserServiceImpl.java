package com.Amarachi._DaysChallenge.api.ServiceImpl;

import com.Amarachi._DaysChallenge.api.Services.UserService;
import com.Amarachi._DaysChallenge.api.Services.AuthenticationService;
import com.Amarachi._DaysChallenge.api.dto.AuthRequest;
import com.Amarachi._DaysChallenge.api.dto.AuthResponse;
import com.Amarachi._DaysChallenge.api.dto.UserProfileDto;
import com.Amarachi._DaysChallenge.api.entities.User;
import com.Amarachi._DaysChallenge.api.exception.ResourceNotFoundException;
import com.Amarachi._DaysChallenge.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;

    @Autowired
    @Lazy
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }

    @Override
    public AuthResponse register(AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        userRepository.save(user);
        return new AuthResponse("User registered successfully");
    }

    @Override
    public AuthResponse login(UserProfileDto authRequest) {
        return authenticationService.authenticate(
                new AuthRequest(authRequest.getUsername(), authRequest.getPassword())
        );
    }

    @Override
    public UserProfileDto createUser(UserProfileDto userProfileDto) {
        User user = new User();
        user.setUsername(userProfileDto.getUsername());
        user.setBio(userProfileDto.getBio());
        user.setProfilePictureUrl(userProfileDto.getProfilePictureUrl());
        user = userRepository.save(user);
        return mapToDto(user);
    }

    @Override
    public UserProfileDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return mapToDto(user);
    }

    @Override
    public UserProfileDto updateUser(Long id, UserProfileDto userProfileDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setUsername(userProfileDto.getUsername());
        user.setBio(userProfileDto.getBio());
        user.setProfilePictureUrl(userProfileDto.getProfilePictureUrl());
        user = userRepository.save(user);
        return mapToDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }

    private UserProfileDto mapToDto(User user) {
        UserProfileDto dto = new UserProfileDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setBio(user.getBio());
        dto.setProfilePictureUrl(user.getProfilePictureUrl());
        return dto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}




