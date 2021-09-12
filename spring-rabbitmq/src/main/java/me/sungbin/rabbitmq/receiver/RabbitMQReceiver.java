package me.sungbin.rabbitmq.receiver;

import lombok.extern.slf4j.Slf4j;
import me.sungbin.rabbitmq.sample.model.MyTask;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQReceiver {

    @RabbitListener(id = "photo.sample", queues = "photo.sample")
    public void handle(MyTask task) {
        log.info("mydata handle:: {}", task.toString());
    }
}
