package com.example.lottery.domain.dto.request;

import com.example.lottery.domain.entity.LotteryHistory;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record LotteryHistoryRequest(
        Long lotteryId,
        LocalDate payCreatedAt,
        Long roundId,
        String userId
) {
    public LotteryHistory toEntity(LotteryHistoryRequest lotteryResultRequest){
        return LotteryHistory.builder()
                .createdAt(payCreatedAt)
                .lotteryId(lotteryResultRequest.lotteryId)
                .roundId(lotteryResultRequest.roundId)
                .lotteryCount(1L)
                .userId(userId)
                .build();
    };
}
