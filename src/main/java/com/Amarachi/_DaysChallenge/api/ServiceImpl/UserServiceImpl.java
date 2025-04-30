package com.Amarachi._DaysChallenge.api.ServiceImpl;

import com.Amarachi._DaysChallenge.api.Services.UserService;
import com.Amarachi._DaysChallenge.api.dto.UserProfileDto;
import com.Amarachi._DaysChallenge.api.entities.User;
import com.Amarachi._DaysChallenge.api.exception.ResourceNotFoundException;
import com.Amarachi._DaysChallenge.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserProfileDto createUser(UserProfileDto userProfileDto) {
        User user = new User();
                user.setUsername(userProfileDto.getUsername());
                user.setBio(userProfileDto.getBio());
                user.setProfilePictureUrl(userProfileDto.getProfilePictureUrl());
                user = userRepository.save(user);

        return mapToDto(user);
    }

    private UserProfileDto mapToDto(User user) {
        UserProfileDto dto = new UserProfileDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setBio(user.getBio());
        dto.setProfilePictureUrl(user.getProfilePictureUrl());
        return dto;g
    }

    @Override
    public UserProfileDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
        return mapToDto(user);
    }

    @Override
    public UserProfileDto updateUser(Long id, UserProfileDto userProfileDto) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
        user.setUsername(userProfileDto.getUsername());
        user.setBio(userProfileDto.getBio());
        user.setProfilePictureUrl(userProfileDto.getProfilePictureUrl());
        user = userRepository.save(user);
        return mapToDto(user);
    }

    @Override
    public void deleteUser(Long id) {
      User user = userRepository.findById(id)
              .orElseThrow(() ->new ResourceNotFoundException("User not found"));
    }
}
