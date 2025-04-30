package com.Amarachi._DaysChallenge.api.dto;
import lombok.Data;

@Data
public class ShareDto {
    private Long postId;
    private String sharedWith;
    private String caption;

}
