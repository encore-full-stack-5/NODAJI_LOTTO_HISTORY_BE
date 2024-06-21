package com.example.lottery.domain.repository;

import com.example.lottery.domain.entity.LotteryResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LottoResultRepository extends JpaRepository<LotteryResult, Long> {
    //유저 ID에 따른 모든 로또 내역 가져오기
    List<LotteryResult> findByUserId(String userId);

}
