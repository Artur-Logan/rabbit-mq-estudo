package com.arturlogan.fazenda_rabbit_mq.services;

import com.arturlogan.fazenda_rabbit_mq.entities.Fazenda;
import com.arturlogan.fazenda_rabbit_mq.repositories.FazendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FazendaService {

    private final FazendaRepository fazendaRepository;
    private ProdutorValidatorService produtor;

    public Fazenda salvar(Fazenda fazenda){
        if (!produtor.produtorExistes(fazenda.getProdutorId().toString())){
            throw new RuntimeException("Produtor não encontrado!");
        }

        return fazendaRepository.save(fazenda);
    }

    public List<Fazenda> obterPorProdutor(UUID idProdutor){
      boolean produtorExiste = produtor.produtorExistes(idProdutor.toString());

      if (!produtorExiste){
          throw new RuntimeException(("Produtor não encontrado!"));
      }

        return fazendaRepository.findByProdutorId(idProdutor);
    }

    public Fazenda obter(UUID uuid){
        Fazenda fazenda = fazendaRepository.findById(uuid).get();

        return fazenda;
    }

    public List<Fazenda> listar(){
        List<Fazenda> fazendas = fazendaRepository.findAll();

        return fazendas;
    }

    public void deletar(UUID uuid){
        Fazenda fazenda = fazendaRepository.findById(uuid).get();

        fazendaRepository.delete(fazenda);
    }

    public Fazenda atualizar(UUID uuid, Fazenda fazenda){
        Fazenda fazendaAtt = fazendaRepository.findById(uuid).get();

        fazendaAtt.setNome(fazenda.getNome());
        fazendaAtt.setLocalizacao(fazenda.getLocalizacao());
        fazendaAtt.setMetrosQuadrados(fazenda.getMetrosQuadrados());
        fazendaAtt.setLocalizacao(fazenda.getLocalizacao());

        fazendaRepository.save(fazendaAtt);

        return fazendaAtt;
    }

}
