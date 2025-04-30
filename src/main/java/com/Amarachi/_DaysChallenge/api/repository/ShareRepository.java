package com.Amarachi._DaysChallenge.api.repository;


import com.Amarachi._DaysChallenge.api.entities.Share;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShareRepository extends JpaRepository<Share, Long> {
    List<Share> findByPostId(Long postId);
}
