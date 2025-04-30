package com.Amarachi._DaysChallenge.api.Services;

import com.Amarachi._DaysChallenge.api.dto.ShareDto;

import java.util.List;

public interface ShareService {
    ShareDto sharePost(Long userId);
    List<ShareDto> getSharesByPost(Long postId);

}
