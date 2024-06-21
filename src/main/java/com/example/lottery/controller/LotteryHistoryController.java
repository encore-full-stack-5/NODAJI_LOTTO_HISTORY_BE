package com.example.lottery.controller;

import com.example.lottery.domain.dto.request.LotteryHistoryRequest;
import com.example.lottery.domain.entity.LotteryHistory;
import com.example.lottery.service.LotteryHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lotto-result")
public class LotteryHistoryController {

    private final LotteryHistoryService historyService;

    //추후 UUID 변경 필요
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LotteryHistory> getAllResult(@PathVariable("userId") String userId) {

        return historyService.getResult(userId);
    }

    //추후 UUID 변경 필요
    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void createResult(@PathVariable("userId") String userId ,@RequestBody LotteryHistoryRequest lotteryResultRequest) {
        historyService.saveResult(userId, lotteryResultRequest);
    }

    @DeleteMapping("/{userId}/{resultId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteResult(@PathVariable("userId") String userId, @PathVariable("resultId") Long resultId) {
        historyService.deleteResult(userId, resultId);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserAllResult(@PathVariable("userId") String userId) {
        historyService.deleteAllResults(userId);
    }


}
