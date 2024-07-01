package com.example.lottery.kafka.dto;

public record KafkaHistoryDto(
        Long payId,
        Long amount,
        Long rank
) {
}
