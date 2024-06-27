package com.example.lottery.domain.dto.request;

public record LotteryResultRequest(
        Long result,
        Long resultMoney
) {
//    public LotteryHistory toEntity(String userId, LotteryResultRequest lotteryResultRequest){
//        return LotteryHistory.builder()
//                .createdAt(LocalDateTime.now())
//                .lotteryid(lotteryResultRequest.lotteryId)
//                .roundId(lotteryResultRequest.roundId)
//                .lotteryCount(1L)
//                .userId(userId)
//                .build();
//    };
}
