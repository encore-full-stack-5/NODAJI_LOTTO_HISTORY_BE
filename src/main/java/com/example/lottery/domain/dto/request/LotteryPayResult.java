package com.example.lottery.domain.dto.request;

import com.example.lottery.domain.entity.LotteryResult;

import java.util.List;

public record LotteryPayResult(
        int lotteryCount,
        List<Long> lottoPaymentId
) {
    public LotteryResult toEntity() {
        return LotteryResult.builder()
                .lotteryCount()
                .build();
    }
}
