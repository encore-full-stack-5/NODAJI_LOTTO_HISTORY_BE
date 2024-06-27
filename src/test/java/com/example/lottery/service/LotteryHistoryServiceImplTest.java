package com.example.lottery.service;

import com.example.lottery.domain.dto.response.HistoryPageResponse;
import com.example.lottery.domain.dto.response.LotteryHistoryResponse;
import com.example.lottery.domain.entity.LotteryHistory;
import com.example.lottery.domain.repository.LottoHistoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LotteryHistoryServiceImplTest {

    @InjectMocks
    private LotteryHistoryServiceImpl lotteryHistoryService;

    @Mock
    private LottoHistoryRepository lottoHistoryRepository;
    @Mock
    private LotteryHistoryResponse lotteryHistoryResponse;


    @Nested
    class getAllResult{
        @Test
        void 성공() {
            //given
            LocalDateTime dateTime = LocalDateTime.of(2000,4,18,12,0);
            String userId = "daniel";
            Pageable pageable = PageRequest.of(0, 10);

            LotteryHistory lotteryHistory1 = new LotteryHistory
                    (1L,123L,dateTime,"daniel",111L,1L,null,null);
            LotteryHistory lotteryHistory2 = new LotteryHistory
                    (2L,123L,dateTime,"daniel",111L,1L,null,null);

            Page<LotteryHistory> content = new PageImpl<>(List.of(lotteryHistory1,lotteryHistory2),pageable,1);

            BDDMockito.given(lottoHistoryRepository.findAllByUserId(userId,pageable)).willReturn(content);

            //when(실제로 코드가 구현될 부분)
            HistoryPageResponse allResult = lotteryHistoryService.getAllResult(userId, 0, 10);

            //then
            assertEquals(0,allResult.pageInfo().get("page"));
            assertEquals(10,allResult.pageInfo().get("size"));
            assertEquals(2L,allResult.pageInfo().get("totalElements"));
            assertEquals(1,allResult.pageInfo().get("totalPages"));
            assertEquals(content.stream().map(LotteryHistoryResponse::from).toList(),allResult.content());

        }
        @Test
        void 실패_값없음(){
            //given
            LocalDateTime dateTime = LocalDateTime.of(2000,4,18,12,0);
            String userId = "daniel";
            Pageable pageable = PageRequest.of(0, 10);

            LotteryHistory lotteryHistory1 = new LotteryHistory
                    (1L,123L,dateTime,"daniel",111L,1L,null,null);
            LotteryHistory lotteryHistory2 = new LotteryHistory
                    (2L,123L,dateTime,"daniel",111L,1L,null,null);

            Page<LotteryHistory> content = new PageImpl<>(List.of(lotteryHistory1,lotteryHistory2),pageable,1);

            BDDMockito.given(lottoHistoryRepository.findAllByUserId(userId,pageable)).willReturn(content);

            //when(실제로 코드가 구현될 부분)
            HistoryPageResponse allResult = lotteryHistoryService.getAllResult(userId, 0, 10);

            //then
            assertEquals(0,allResult.pageInfo().get("page"));
            assertEquals(10,allResult.pageInfo().get("size"));
            assertEquals(2L,allResult.pageInfo().get("totalElements"));
            assertEquals(1,allResult.pageInfo().get("totalPages"));
            assertEquals(Collections.emptyList(), allResult.content());
        }

    }


    @Test
    void saveResult() {
    }

    @Test
    void updateResult() {
    }
}