package com.Amarachi._DaysChallenge.api.ServiceImpl;

import com.Amarachi._DaysChallenge.api.Services.ShareService;
import com.Amarachi._DaysChallenge.api.entities.Post;
import com.Amarachi._DaysChallenge.api.entities.Share;
import com.Amarachi._DaysChallenge.api.entities.User;
import com.Amarachi._DaysChallenge.api.repository.PostRepository;
import com.Amarachi._DaysChallenge.api.repository.ShareRepository;
import com.Amarachi._DaysChallenge.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShareServiceImpl implements ShareService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ShareRepository shareRepository;

    @Autowired
    public ShareServiceImpl(PostRepository postRepository, UserRepository userRepository, ShareRepository shareRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.shareRepository = shareRepository;
    }

    @Override
    public void sharePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Share share = new Share();
        share.setPost(post);
        share.setUser(user);
        share.setSharedAt(LocalDateTime.now());

        shareRepository.save(share);
    }
}


