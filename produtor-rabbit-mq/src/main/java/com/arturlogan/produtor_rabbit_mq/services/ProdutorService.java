package com.arturlogan.produtor_rabbit_mq.services;

import com.arturlogan.produtor_rabbit_mq.entities.Produtor;
import com.arturlogan.produtor_rabbit_mq.repositories.ProdutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutorService {

    private final ProdutorRepository produtorRepository;

    public Produtor salvar(Produtor produtor){
        return produtorRepository.save(produtor);
    }

    public List<Produtor> listarTodos(){
        List<Produtor> produtors = produtorRepository.findAll();

        return produtors;
    }

    public void deletar(UUID uuid){
        Produtor produtor = produtorRepository.findById(uuid).get();

        produtorRepository.delete(produtor);
    }

    public Produtor buscar(UUID uuid){
        Produtor produtor = produtorRepository.findById(uuid).get();

        return produtor;
    }

    public Produtor atualizar(UUID uuid, Produtor produtor){
        Produtor produtorAtt = produtorRepository.findById(uuid).get();

        produtorAtt.setNomeCompleto(produtor.getNomeCompleto());
        produtorAtt.setCpf(produtor.getCpf());
        produtorAtt.setTelefone(produtor.getTelefone());

        produtorRepository.save(produtorAtt);

        return produtorAtt;

    }
}
