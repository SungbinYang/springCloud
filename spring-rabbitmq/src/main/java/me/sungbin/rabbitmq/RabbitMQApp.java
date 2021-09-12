package me.sungbin.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RabbitMQApp {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApp.class, args);
    }
}
