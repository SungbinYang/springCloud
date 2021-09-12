package me.sungbin.kafka.eventService;

import lombok.RequiredArgsConstructor;
import me.sungbin.kafka.sender.KafkaProducer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MyEventService {

    private final KafkaProducer kafkaProducer;

    public void sendMsg() {
        Map<String, Object> data = new HashMap<>();

        data.put("width", 1020);
        data.put("height", 768);

        kafkaProducer.send(KafkaProducer.TOPIC_NAME, new MyEvent(data));
    }
}
