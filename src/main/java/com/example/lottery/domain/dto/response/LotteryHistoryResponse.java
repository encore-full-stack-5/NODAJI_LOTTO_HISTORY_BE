package com.example.lottery.domain.dto.response;

import com.example.lottery.domain.entity.LotteryHistory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record LotteryHistoryResponse(
        Long payId,
        Long lotteryId,
        LocalDate payCreatedAt,
        Long roundId,
        Long lotteryCount,
        Long result,
        Long resultMoney
) {
    public static LotteryHistoryResponse from(LotteryHistory lotteryHistory) {
        return new LotteryHistoryResponse(lotteryHistory.getPayId(),lotteryHistory.getLotteryId(), lotteryHistory.getCreatedAt(),
                lotteryHistory.getRoundId(),lotteryHistory.getLotteryCount(),lotteryHistory.getResult(),lotteryHistory.getResultMoney());
    }
}
