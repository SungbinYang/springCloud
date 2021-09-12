package me.sungbin.rabbitmq.sender;

import lombok.RequiredArgsConstructor;
import me.sungbin.rabbitmq.config.RabbitMQConfig;
import me.sungbin.rabbitmq.sample.model.MyTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    final RabbitMessagePublisher rabbitMessagePublisher;

    @GetMapping("/send")
    public String sendData(@RequestParam(defaultValue = "") String msg) {
        rabbitMessagePublisher.publish(RabbitMQConfig.RABBIT_EXCHAGNGE_NAME, new MyTask(msg));

        return "send Data";
    }
}
