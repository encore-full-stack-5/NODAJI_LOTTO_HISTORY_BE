package com.example.lottery.kafka.dto;

import java.time.LocalDate;

public record KafkaPayDto(
        Long id,
        String userId,
        LocalDate createAt,
        Long round
) {
}
