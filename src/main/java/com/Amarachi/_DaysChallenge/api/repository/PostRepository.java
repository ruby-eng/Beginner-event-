package com.Amarachi._DaysChallenge.api.repository;




import com.Amarachi._DaysChallenge.api.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}

