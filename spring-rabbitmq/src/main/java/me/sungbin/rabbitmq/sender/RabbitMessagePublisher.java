package me.sungbin.rabbitmq.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sungbin.rabbitmq.sample.model.MyTask;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publish(String routingKey, MyTask myTask) {
        try {
            rabbitTemplate.convertAndSend("sungbin", "photo.sample", myTask);
        } catch (Exception e) {
            log.error("error", e);
        }
    }
}
