package com.example.lottery.domain.dto.request;

import com.example.lottery.domain.entity.LotteryHistory;

import java.time.LocalDateTime;

public record LotteryHistoryRequest(
    Long lotteryCount
) {
    public LotteryHistory toEntity(String userId, LotteryHistoryRequest lotteryResultRequest){
        return LotteryHistory.builder()
                .createdAt(LocalDateTime.now())
                .lotteryCount(lotteryResultRequest.lotteryCount())
                .userId(userId)
                .build();
    };
}
