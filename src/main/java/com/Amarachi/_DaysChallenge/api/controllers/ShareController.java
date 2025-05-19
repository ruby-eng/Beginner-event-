package com.Amarachi._DaysChallenge.api.controllers;

import com.Amarachi._DaysChallenge.api.Services.ShareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/share")
public class ShareController {

    private final ShareService shareService;

    public ShareController(ShareService shareService) {
        this.shareService = shareService;
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Void> sharePost(
            @PathVariable Long postId,
            @RequestParam Long userId
    ) {
        shareService.sharePost(postId, userId);
        return ResponseEntity.ok().build();
    }
}



