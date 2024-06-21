package com.example.lottery.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LOTTERY_RESULTS")
public class LotteryResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PAY_LOG_ID")
    private Long payid;
    @Column(name = "PAY_CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "LOTTERY_COUNT")
    private Long lotteryCount;
    @Column(name = "RESULT",nullable = true)
    private String result;
    @Column(name = "RESULT_MONEY",nullable = true)
    private Long resultMoney;
    @Column(name = "USER_ID")
    private String userId;

}
