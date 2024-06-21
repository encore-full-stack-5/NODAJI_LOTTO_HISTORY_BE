package com.example.lottery.domain.dto.request;

import com.example.lottery.domain.entity.LotteryResult;

import java.time.LocalDateTime;

public record LotteryResultRequest(
    Long lotteryCount
) {
    public LotteryResult toEntity(String userId, LotteryResultRequest lotteryResultRequest){
        return LotteryResult.builder()
                .createdAt(LocalDateTime.now())
                .lotteryCount(lotteryResultRequest.lotteryCount())
                .userId(userId)
                .build();
    };
}
