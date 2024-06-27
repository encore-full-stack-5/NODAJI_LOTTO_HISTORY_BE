package com.example.lottery.domain.dto.response;

import java.util.List;
import java.util.Map;

public record HistoryPageResponse(
        Map<String, Object> pageInfo,
        List<LotteryHistoryResponse> content
) {
}
