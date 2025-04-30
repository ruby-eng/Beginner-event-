package com.Amarachi._DaysChallenge.api.Services;

import com.Amarachi._DaysChallenge.api.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(Long userId,PostDto postDto);
    PostDto getPostById(Long id);
    List<PostDto> getPostByUser(Long userId);
    PostDto updatePost(Long id, PostDto postDto);
    void deletePost(Long id);
}
