package me.sungbin.rabbitmq.sender;

import me.sungbin.rabbitmq.config.RabbitQueue;
import me.sungbin.rabbitmq.sample.model.MyTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RabbitMQSenderTest {

    @Autowired
    private RabbitMessagePublisher publisher;

    @Test
    public void sendMsg() {
        String msg = "you guys do something!!!";
        publisher.publish(RabbitQueue.SAMPLE_TASK.getQueueName(), new MyTask(msg));
    }
}