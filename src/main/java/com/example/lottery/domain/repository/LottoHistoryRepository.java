package com.example.lottery.domain.repository;

import com.example.lottery.domain.entity.LotteryHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LottoHistoryRepository extends JpaRepository<LotteryHistory, Long> {
    //유저 ID에 따른 모든 로또 내역 가져오기
    Page<LotteryHistory> findAllByUserId(String userId, Pageable pageable);
    LotteryHistory findByUserId(String userId);

}
