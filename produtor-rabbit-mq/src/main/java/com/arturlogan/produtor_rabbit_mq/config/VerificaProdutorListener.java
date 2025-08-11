package com.arturlogan.produtor_rabbit_mq.config;

import com.arturlogan.produtor_rabbit_mq.repositories.ProdutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class VerificaProdutorListener {

    private final ProdutorRepository produtorRepository;

    @RabbitListener(queues = "verifica-produtor")
    public boolean verificaProdutor(String uuid){
        try{
            UUID produtorId = UUID.fromString(uuid);
            return produtorRepository.existsById(produtorId);
        }  catch (IllegalArgumentException e) {
            return false;
        }
    }
}
