package com.example.lottery.controller;

import com.example.lottery.domain.dto.request.LotteryResultRequest;
import com.example.lottery.domain.entity.LotteryResult;
import com.example.lottery.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lotto-result")
public class LottoResultController {

    private final ResultService resultService;

    //추후 UUID 변경 필요
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LotteryResult> getAllResult(@PathVariable("userId") String userId) {

        return resultService.getResult(userId);
    }

    //추후 UUID 변경 필요
    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void createResult(@PathVariable("userId") String userId ,@RequestBody LotteryResultRequest lotteryResultRequest) {
        resultService.saveResult(userId, lotteryResultRequest);
    }

    @DeleteMapping("/{userId}/{resultId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteResult(@PathVariable("userId") String userId, @PathVariable("resultId") Long resultId) {
        resultService.deleteResult(userId, resultId);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserAllResult(@PathVariable("userId") String userId) {
        resultService.deleteAllResults(userId);
    }


}
