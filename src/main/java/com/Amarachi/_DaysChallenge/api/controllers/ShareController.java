package com.Amarachi._DaysChallenge.api.controllers;

import com.Amarachi._DaysChallenge.api.Services.ShareService;
import com.Amarachi._DaysChallenge.api.dto.ShareDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/share")
@RequiredArgsConstructor
public class ShareController {

    private final ShareService shareService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> sharePost(@PathVariable Long postId) {
        shareService.sharePost(postId)
        return ResponseEntity.ok().build();
    }
}

