//package com.example.lottery.kafka;
//
//import com.example.lottery.kafka.dto.KafkaHistoryDto;
//import com.example.lottery.kafka.dto.KafkaPayDto;
//import com.example.lottery.kafka.dto.KafkaStatus;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.common.serialization.Deserializer;
//
//import java.util.Map;
//
//public class CustomKafkaStatusDeserializer implements Deserializer<KafkaStatus<?>> {
//
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//    }
//
//    @Override
//    public KafkaStatus<?> deserialize(String topic, byte[] data) {
//        try {
//            // 메시지를 일반 Map으로 역직렬화하여 status를 확인
//            Map<String, Object> map = objectMapper.readValue(data, Map.class);
//            String status = (String) map.get("status");
//
//            if ("history".equals(status)) {
//                return objectMapper.readValue(data, objectMapper.getTypeFactory().constructParametricType(KafkaStatus.class, KafkaHistoryDto.class));
//            } else if ("pay".equals(status)) {
//                return objectMapper.readValue(data, objectMapper.getTypeFactory().constructParametricType(KafkaStatus.class, KafkaPayDto.class));
//            } else {
//                throw new IllegalArgumentException("Unknown status type");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to deserialize Kafka message", e);
//        }
//    }
//
//    @Override
//    public void close() {
//    }
//}
//
