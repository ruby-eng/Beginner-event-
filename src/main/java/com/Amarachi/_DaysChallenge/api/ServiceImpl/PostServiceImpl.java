package com.Amarachi._DaysChallenge.api.ServiceImpl;


import com.Amarachi._DaysChallenge.api.Services.PostService;
import com.Amarachi._DaysChallenge.api.dto.PostDto;
import com.Amarachi._DaysChallenge.api.entities.Post;
import com.Amarachi._DaysChallenge.api.entities.User;
import com.Amarachi._DaysChallenge.api.repository.PostRepository;
import com.Amarachi._DaysChallenge.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        User user = userRepository.findById(postDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setContent(postDto.getContent());
        post.setImageUrl(postDto.getImageUrl());
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());

        post = postRepository.save(post);

        return new PostDto(
                post.getId(),
                post.getContent(),
                post.getImageUrl(),
                post.getCreatedAt(),
                post.getUser().getId()
        );
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        return new PostDto(
                post.getId(),
                post.getContent(),
                post.getImageUrl(),
                post.getCreatedAt(),
                post.getUser().getId()
        );
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setContent(postDto.getContent());
        post.setImageUrl(postDto.getImageUrl());

        post = postRepository.save(post);

        return new PostDto(
                post.getId(),
                post.getContent(),
                post.getImageUrl(),
                post.getCreatedAt(),
                post.getUser().getId()
        );
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream().map(post ->
                new PostDto(
                        post.getId(),
                        post.getContent(),
                        post.getImageUrl(),
                        post.getCreatedAt(),
                        post.getUser().getId()
                )
        ).collect(Collectors.toList());
    }
}




