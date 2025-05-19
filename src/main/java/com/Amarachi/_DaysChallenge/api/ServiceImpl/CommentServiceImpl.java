package com.Amarachi._DaysChallenge.api.ServiceImpl;

import com.Amarachi._DaysChallenge.api.Services.CommentService;
import com.Amarachi._DaysChallenge.api.dto.CommentDto;
import com.Amarachi._DaysChallenge.api.entities.Comment;
import com.Amarachi._DaysChallenge.api.entities.Post;
import com.Amarachi._DaysChallenge.api.entities.User;
import com.Amarachi._DaysChallenge.api.repository.CommentRepository;
import com.Amarachi._DaysChallenge.api.repository.PostRepository;
import com.Amarachi._DaysChallenge.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    // 1. Add comment to post (Including username for user identification)
    @Override
    public CommentDto addComment(CommentDto commentDto, String username) {
        // Fetch post by ID
        Post post = postRepository.findById(commentDto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        // Fetch user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create new comment entity
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());  // Set the comment content
        comment.setPost(post);  // Set the post associated with the comment
        comment.setUser(user);  // Set the user who made the comment
        comment.setCreatedAt(LocalDateTime.now()); // Set the current time as the creation time

        // Save comment to the repository
        Comment savedComment = commentRepository.save(comment);

        // Map the saved comment to a DTO and return it
        return mapToDto(savedComment);
    }

    // 2. Create comment (This is redundant since addComment already handles creation)
    @Override
    public CommentDto createComment(CommentDto commentDto) {
        return null;
    }

    // 3. Get all comments for a specific post
    @Override
    public List<CommentDto> getCommentsByPost(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        // Map comments to DTOs and return the list
        return comments.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // 4. Delete comment by ID
    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        commentRepository.delete(comment);
    }

    // Internal helper to map Comment entity to CommentDto
    private CommentDto mapToDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setPostId(comment.getPost().getId());
        dto.setUserId(comment.getUser().getId());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }
}


