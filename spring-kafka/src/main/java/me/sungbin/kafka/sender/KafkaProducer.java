package me.sungbin.kafka.sender;

import lombok.RequiredArgsConstructor;
import me.sungbin.kafka.eventService.JacksonConverter;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    public static final String TOPIC_NAME = "sungbin";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, Object data) {
        try {
            kafkaTemplate.send(topic, JacksonConverter.toJson(data));
        } catch (Exception e) {
            System.err.println("error" + e.getMessage());
        }
    }
}
