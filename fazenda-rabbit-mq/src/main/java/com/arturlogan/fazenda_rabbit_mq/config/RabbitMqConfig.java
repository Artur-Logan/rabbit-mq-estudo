package com.arturlogan.fazenda_rabbit_mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory; // ✅ Correto
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class RabbitMqConfig {

    public static final String VERIFICA_PRODUTOR_QUEUE = "verifica-produtor";

    @Bean
    public Queue verificaProdutorQueue() {
        return new Queue(VERIFICA_PRODUTOR_QUEUE, false);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);

        SimpleMessageConverter messageConverter = new SimpleMessageConverter();
        messageConverter.setAllowedListPatterns(Collections.singletonList("java.lang.Boolean"));

        template.setMessageConverter(messageConverter);
        return template;
    }
}
