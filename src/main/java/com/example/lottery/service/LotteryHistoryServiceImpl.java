package com.example.lottery.service;

import com.example.lottery.domain.dto.request.LotteryHistoryRequest;
import com.example.lottery.domain.dto.request.LotteryResultRequest;
import com.example.lottery.domain.dto.response.HistoryPageResponse;
import com.example.lottery.domain.dto.response.LotteryHistoryResponse;
import com.example.lottery.domain.entity.LotteryHistory;
import com.example.lottery.domain.repository.LottoHistoryRepository;
import com.example.lottery.kafka.dto.KafkaHistoryDto;
import com.example.lottery.kafka.dto.KafkaPayDto;
import com.example.lottery.kafka.dto.KafkaStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LotteryHistoryServiceImpl implements LotteryHistoryService {
    private final LottoHistoryRepository lottoHistoryRepository;


    @Override
    public HistoryPageResponse getAllResult(String userId, Integer page, Integer pageSize) {
        Page<LotteryHistory> content = lottoHistoryRepository.findAllByUserId(userId, PageRequest.of(page, pageSize));
        System.out.println("content:" + content);
        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("page", page);
        pageInfo.put("size", pageSize);
        pageInfo.put("totalElements", content.getTotalElements());
        pageInfo.put("totalPages", content.getTotalPages());
        System.out.println("pageInfo:" + pageInfo);

        return new HistoryPageResponse(pageInfo,content.stream().map((e) -> {return LotteryHistoryResponse.from(e);}).toList());
    }

//    @Override
//    public List<LotteryHistoryResponse> getAllResult(String userId) {
//        if (lottoHistoryRepository.findByUserId(userId).isEmpty()) throw new IllegalArgumentException("해당 유저 아이디없음");
//        return lottoHistoryRepository.findByUserId(userId).stream().map(LotteryHistoryResponse::from).toList();
////        List<LotteryHistoryResponse> byUserId = lottoHistoryRepository.findByUserId(userId);
////        if (byUserId.isEmpty()) {
////            throw new IllegalArgumentException("해당 유저 아이디 없음");
////        }
////        return byUserId;
//    }

//    @Override
//    public LotteryHistoryResponse getResult(String userId, Long payId) {
//        if(lottoHistoryRepository.findByUserId(userId).isEmpty()) throw new IllegalArgumentException("해당 유저 없음");
//        return lottoHistoryRepository.findById(payId).orElseThrow(() -> new IllegalArgumentException("해당 결과 ID 없음"));
//    }

    @Override
    public void saveResult(LotteryHistoryRequest request) {
        lottoHistoryRepository.save(request.toEntity(request));
    }

    @KafkaListener(topics = "history-topic")
    public void synchronization(KafkaStatus<KafkaHistoryDto> status){
        switch(status.status()){
            case "history" ->{
                System.out.println(status.data());
                LotteryHistory history = lottoHistoryRepository.findByUserId(status.data().userId());
                if(history == null) throw new IllegalArgumentException("해당 유저 없음");
                history.setResult(status.data().rank());
                history.setResultMoney(status.data().amount());
                lottoHistoryRepository.save(history);
            }
        }
    }

    @KafkaListener(topics = "history-topic")
    public void synchronization1(KafkaStatus<KafkaPayDto> status){
        switch(status.status()){
            case "pay" ->{
                System.out.println(status.data());
                LotteryHistoryRequest lotteryHistoryRequest =
                        new LotteryHistoryRequest(status.data().id(),status.data().createAt(),status.data().round(),
                                status.data().userId());
                LotteryHistory entity = lotteryHistoryRequest.toEntity(lotteryHistoryRequest);
                lottoHistoryRepository.save(entity);
            }
        }
    }


//    //특정 내역 삭제하기(내역 ID)
//    @Override
//    public void deleteResult(String userId, Long payId) {
//        if(lottoHistoryRepository.findByUserId(userId).isEmpty()) throw new IllegalArgumentException("해당 유저 없음");
//        lottoHistoryRepository.findById(payId).orElseThrow(() ->new IllegalArgumentException("해당 결과 ID 없음"));
//        lottoHistoryRepository.deleteById(payId);
//    }



    @Override
    public void updateResult(String userId, Long payId, LotteryResultRequest request) {
        //유저의 내역정보를 업데이트
        //유저의 정보를 가져옴
        LotteryHistory history = lottoHistoryRepository.findByUserId(userId);
        if(history == null) throw new IllegalArgumentException("해당 유저 없음");
//        LotteryHistory history = lottoHistoryRepository.findById(payId).orElseThrow(() -> new IllegalArgumentException("해당 결과 ID 없음"));
        // 필요한 정보만 수정, 업데이트
        history.setResult(request.result());
        history.setResultMoney(request.resultMoney());

        lottoHistoryRepository.save(history);
    }



//    //유저 모든 내역 삭제하기(유저 ID)
//    @Override
//    public void deleteAllResults(String userId) {
//        LotteryHistory byUserId = lottoHistoryRepository.findByUserId(userId);
//        if(byUserId == null){
//            throw new IllegalArgumentException("해당 유저 ID 없음");
//        }
//        lottoHistoryRepository.deleteAll(byUserId);
//    }


}
