package com.Amarachi._DaysChallenge.api.repository;


import com.Amarachi._DaysChallenge.api.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}


