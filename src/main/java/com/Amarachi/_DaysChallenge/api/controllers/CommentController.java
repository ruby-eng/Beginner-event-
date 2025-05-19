package com.Amarachi._DaysChallenge.api.controllers;

import com.Amarachi._DaysChallenge.api.Services.CommentService;
import com.Amarachi._DaysChallenge.api.dto.CommentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;  // Declare CommentService

    // Manually defining the constructor for CommentService injection
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 1. Add a new comment
    @PostMapping
    public CommentDto addComment(@RequestBody CommentDto commentDto, @RequestParam String username) {
        return commentService.addComment(commentDto, username);
    }

    // 2. Get all comments for a specific post
    @GetMapping("/post/{postId}")
    public List<CommentDto> getCommentsByPost(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }

    // 3. Delete comment by ID
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}


