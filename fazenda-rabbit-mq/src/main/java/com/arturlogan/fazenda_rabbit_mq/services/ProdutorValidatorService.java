package com.arturlogan.fazenda_rabbit_mq.services;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutorValidatorService {

    private final RabbitTemplate rabbitTemplate;

    public boolean produtorExistes(String uuid){
        Object response = rabbitTemplate.convertSendAndReceive("verifica-produtor", uuid);
        return response instanceof Boolean && (Boolean) response;
    }
}
