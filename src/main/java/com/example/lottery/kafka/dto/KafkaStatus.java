package com.example.lottery.kafka.dto;

public record KafkaStatus<T>(
        T data, String status
) {
}

