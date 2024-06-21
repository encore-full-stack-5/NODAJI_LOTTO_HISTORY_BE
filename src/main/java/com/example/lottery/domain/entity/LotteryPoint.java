package com.example.lottery.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LOTTERY_POINTS")
public class LotteryPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POINT_ID")
    private Long id;

    @Column(name = "PAY_LOG_ID")
    private Long payid;

    @Column(name = "TOTAL_POINT")
    private Long totalPoint;


}
