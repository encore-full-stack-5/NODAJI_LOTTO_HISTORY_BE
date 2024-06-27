package com.example.lottery.service;

import com.example.lottery.domain.dto.request.LotteryHistoryRequest;
import com.example.lottery.domain.dto.request.LotteryResultRequest;
import com.example.lottery.domain.dto.response.HistoryPageResponse;
import com.example.lottery.domain.dto.response.LotteryHistoryResponse;
import com.example.lottery.domain.entity.LotteryHistory;

import java.util.List;

public interface LotteryHistoryService {
    HistoryPageResponse getAllResult(String userId, Integer page, Integer pageSize);
    //    List<LotteryHistoryResponse> getAllResult(String userId);
//    LotteryHistoryResponse getResult(String userId, Long payId);
    void saveResult(LotteryHistoryRequest request);
    void updateResult(String userId,Long PayId, LotteryResultRequest request);
    //추후 UUID 변경 필요
//    void deleteAllResults(String userId);
}
