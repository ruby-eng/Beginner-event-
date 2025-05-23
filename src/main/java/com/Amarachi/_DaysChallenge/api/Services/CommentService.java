package com.Amarachi._DaysChallenge.api.Services;

import com.Amarachi._DaysChallenge.api.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto addComment(CommentDto commentDto, String username);

    CommentDto createComment(CommentDto commentDto);
    List<CommentDto> getCommentsByPost(Long postId);
    void deleteComment(Long id);



}
