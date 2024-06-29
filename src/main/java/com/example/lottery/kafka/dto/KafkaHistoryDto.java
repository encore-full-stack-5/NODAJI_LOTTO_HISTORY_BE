package com.example.lottery.kafka.dto;

public record KafkaHistoryDto(
        String userId,
        Long amount,
        Long rank
) {
}
