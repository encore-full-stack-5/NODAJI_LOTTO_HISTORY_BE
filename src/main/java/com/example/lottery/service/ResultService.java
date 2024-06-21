package com.example.lottery.service;

import com.example.lottery.domain.dto.request.LotteryResultRequest;
import com.example.lottery.domain.entity.LotteryResult;

import java.util.List;

public interface ResultService {
    List<LotteryResult> getResult(String userId);
    void saveResult(String userId, LotteryResultRequest request);
    void deleteResult(String userId, Long resultId);
    void updateResult(String userId, LotteryResultRequest request);
    //추후 UUID 변경 필요
    void deleteAllResults(String userId);
}
