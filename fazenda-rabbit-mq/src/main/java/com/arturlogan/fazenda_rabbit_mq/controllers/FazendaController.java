package com.arturlogan.fazenda_rabbit_mq.controllers;

import com.arturlogan.fazenda_rabbit_mq.entities.Fazenda;
import com.arturlogan.fazenda_rabbit_mq.services.FazendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/fazenda")
public class FazendaController {

    private final FazendaService fazendaService;

    @GetMapping
    public ResponseEntity<List<Fazenda>> listar(){
        List<Fazenda> fazendas = fazendaService.listar();

        return ResponseEntity.ok().body(fazendas);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity obter(@PathVariable UUID uuid){
        Fazenda fazenda = fazendaService.obter(uuid);

        return ResponseEntity.ok().body(fazenda);
    }

    @GetMapping("/fazendas-por-produtor/{uuid}")
    public ResponseEntity<List<Fazenda>> obterFazendasPorProdutor(@PathVariable UUID uuid){
        List<Fazenda> fazendas = fazendaService.obterPorProdutor(uuid);

        return ResponseEntity.ok().body(fazendas);
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Fazenda fazenda){
        Fazenda fazendaSalva = fazendaService.salvar(fazenda);

        return ResponseEntity.ok().body(fazendaSalva);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletar(@PathVariable UUID uuid){
        fazendaService.deletar(uuid);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Fazenda> atualizar(@RequestBody Fazenda fazenda, @PathVariable UUID uuid){
        Fazenda fazendaAtt = fazendaService.atualizar(uuid, fazenda);

        return ResponseEntity.ok().body(fazendaAtt);
    }


}
