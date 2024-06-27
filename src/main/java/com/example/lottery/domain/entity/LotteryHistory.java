package com.example.lottery.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LOTTERY_HISTORIES")
public class LotteryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PAY_LOG_ID")
    private Long payId;
    @Column(name = "LOTTERY_ID")
    private Long lotteryId;
    @Column(name = "PAY_CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "USER_ID")
    private String userId;    @Column(name = "ROUND_ID")
    private Long roundId;
    @Column(name = "LOTTERY_COUNT")
    private Long lotteryCount;
    @Column(name = "RESULT",nullable = true)
    private Long result;
    @Column(name = "RESULT_MONEY",nullable = true)
    private Long resultMoney;


}
