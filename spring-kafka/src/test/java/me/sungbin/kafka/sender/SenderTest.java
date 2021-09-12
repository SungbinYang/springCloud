package me.sungbin.kafka.sender;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SenderTest {

    @Autowired
    private KafkaProducer producer;

    @Test
    void sendMsg() {
        producer.send("sungbin", "hello kafka");
    }

}