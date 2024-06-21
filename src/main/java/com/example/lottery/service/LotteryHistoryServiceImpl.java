package com.example.lottery.service;

import com.example.lottery.domain.dto.request.LotteryHistoryRequest;
import com.example.lottery.domain.entity.LotteryHistory;
import com.example.lottery.domain.repository.LottoHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LotteryHistoryServiceImpl implements LotteryHistoryService {
    private final LottoHistoryRepository lottoHistoryRepository;

    @Override
    public List<LotteryHistory> getResult(String userId) {
        List<LotteryHistory> byUserId = lottoHistoryRepository.findByUserId(userId);
        if (byUserId.isEmpty()) {
            throw new IllegalArgumentException("해당 유저 아이디 없음");
        }
        return byUserId;
    }

    @Override
    public void saveResult(String userId, LotteryHistoryRequest request) {
        lottoHistoryRepository.save(request.toEntity(userId,request));
    }



    //특정 내역 삭제하기(내역 ID)
    @Override
    public void deleteResult(String userId, Long resultId) {
        if(lottoHistoryRepository.findByUserId(userId).isEmpty()) throw new IllegalArgumentException("해당 유저 없음");
        lottoHistoryRepository.findById(resultId).orElseThrow(() ->new IllegalArgumentException("해당 결과 ID 없음"));
        lottoHistoryRepository.deleteById(resultId);
    }

    @Override
    public void updateResult(String userId, LotteryHistoryRequest request) {
        //유저의 내역정보를 업데이트
        //유저의 정보를 가져옴
        List<LotteryHistory> byUserId = lottoHistoryRepository.findByUserId(userId);
        // 필요한 정보만 수정
        //업데이트
//        request.toEntity(userId, request)
    }

    //유저 모든 내역 삭제하기(유저 ID)
    @Override
    public void deleteAllResults(String userId) {
        List<LotteryHistory> byUserId = lottoHistoryRepository.findByUserId(userId);
        if(byUserId.isEmpty()){
            throw new IllegalArgumentException("해당 유저 ID 없음");
        }
        lottoHistoryRepository.deleteAll(byUserId);
    }


}
