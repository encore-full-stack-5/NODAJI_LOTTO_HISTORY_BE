package com.example.lottery.controller;

import com.example.lottery.domain.dto.request.LotteryHistoryRequest;
import com.example.lottery.domain.dto.request.LotteryResultRequest;
import com.example.lottery.domain.dto.response.HistoryPageResponse;
import com.example.lottery.domain.dto.response.LotteryHistoryResponse;
import com.example.lottery.service.LotteryHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lotto-history")
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class LotteryHistoryController {

    private final LotteryHistoryService historyService;

    //추후 UserId 는 UUID 변경 필요
    //특정 유저의 모든 내역 GET
    @GetMapping("{userId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoryPageResponse getAllResult(
            @PathVariable("userId") String userId,
            @RequestParam(name = "page", defaultValue = "0",required = false) Integer page,
            @RequestParam(name = "pageSize", defaultValue = "10",required = false) Integer pageSize
    ) {

        return historyService.getAllResult(userId,page,pageSize);
    }

//    //특정 유저의 특정 구매내역 GET
//    @GetMapping("/{userId}/{payId}")
//    @ResponseStatus(HttpStatus.OK)
//    public LotteryHistory getResult(@PathVariable("userId") String userId, @PathVariable("payId") Long payId) {
//        return historyService.getResult(userId,payId);
//    }

    //추후 UUID 변경 필요
    //특정 유저에 구매내역 POST
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createResult(@RequestBody LotteryHistoryRequest lotteryHistoryRequest) {
        historyService.saveResult(lotteryHistoryRequest);
    }

//    //특정 유저의 특정 구매내역 DELETE
//    @DeleteMapping("/{userId}/{payId}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteResult(@PathVariable("userId") String userId, @PathVariable("payId") Long payId) {
//        historyService.deleteResult(userId, payId);
//    }
//
//    //특정 유저의 모든 내역 DELETE
//    @DeleteMapping("/{userId}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteUserAllResult(@PathVariable("userId") String userId) {
//        historyService.deleteAllResults(userId);
//    }

    //당첨결과, 당첨금 Update
    @PutMapping("/{userId}/{payId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateResult(@PathVariable("userId") String userId, @PathVariable("payId") Long payId, @RequestBody LotteryResultRequest lotteryResultRequest) {
        historyService.updateResult(userId, payId, lotteryResultRequest);
    }


}
