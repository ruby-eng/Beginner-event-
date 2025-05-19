package com.Amarachi._DaysChallenge.api.Services;

import com.Amarachi._DaysChallenge.api.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(Long id);

    PostDto updatePost(Long id, PostDto postDto);
    void deletePost(Long id);

    List<PostDto> getAllPosts();
}
