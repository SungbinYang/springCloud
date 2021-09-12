package me.sungbin.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import me.sungbin.rabbitmq.sample.model.MyTask;
import me.sungbin.rabbitmq.utils.jackson.JacksonsConverter;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Resource
    private RabbitProperties rabbitProperties;

    public static final String RABBIT_EXCHAGNGE_NAME = "sungbin";
    private static final Integer CONSUMER_COUNT = 5;

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("myTask", MyTask.class);
        classMapper.setIdClassMapping(idClassMapping);
        return classMapper;
    }

    @Bean
    public MessageConverter rabbitMessageConverter() {
        Jackson2JsonMessageConverter jsonConverter = new Jackson2JsonMessageConverter(JacksonsConverter.getInstance());
        jsonConverter.setClassMapper(classMapper());
        return jsonConverter;
    }

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        log.info("userName:: {}", rabbitProperties.getUsername());
        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());
        connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CHANNEL);

        return connectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory rabbitConnectionFactory) {
        final RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitConnectionFactory);

        // exchange 등록
        rabbitExchange(rabbitAdmin);

        ///queue 자동 등록
        for (RabbitQueue rabbitQueue : RabbitQueue.values()) {
            rabbitAdmin.declareQueue(new Queue(rabbitQueue.getQueueName(), true));
            rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue(rabbitQueue.getQueueName(), true))
                    .to(rabbitExchange(rabbitAdmin)).with(rabbitQueue.getQueueName()));
        }

        rabbitAdmin.afterPropertiesSet();
        return rabbitAdmin;
    }

    @Bean
    TopicExchange rabbitExchange(RabbitAdmin rabbitAdmin) {
        TopicExchange topicExchange = new TopicExchange(RABBIT_EXCHAGNGE_NAME);
        topicExchange.setAdminsThatShouldDeclare(rabbitAdmin);
        return topicExchange;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory rabbitConnectionFactory,
                                         MessageConverter rabbitMessageConverter) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(rabbitConnectionFactory);
        rabbitTemplate.setMessageConverter(rabbitMessageConverter);
        rabbitTemplate.setExchange(RABBIT_EXCHAGNGE_NAME);

        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if(ack) {
                log.info("success");
            }else{
                log.error("error {}", cause);
            }
        }));

        return rabbitTemplate;
    }
}
