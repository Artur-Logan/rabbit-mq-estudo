package com.arturlogan.produtor_rabbit_mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory; // ✅ Correto
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
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory); // ✅ Sem cast desnecessário

        SimpleMessageConverter messageConverter = new SimpleMessageConverter();
        messageConverter.setAllowedListPatterns(Collections.singletonList("java.lang.Boolean"));

        factory.setMessageConverter(messageConverter);
        return factory;
    }
}
