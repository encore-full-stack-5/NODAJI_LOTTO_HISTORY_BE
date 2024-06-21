package com.example.lottery.service;

import com.example.lottery.domain.dto.request.LotteryHistoryRequest;
import com.example.lottery.domain.entity.LotteryHistory;

import java.util.List;

public interface LotteryHistoryService {
    List<LotteryHistory> getResult(String userId);
    void saveResult(String userId, LotteryHistoryRequest request);
    void deleteResult(String userId, Long resultId);
    void updateResult(String userId, LotteryHistoryRequest request);
    //추후 UUID 변경 필요
    void deleteAllResults(String userId);
}
