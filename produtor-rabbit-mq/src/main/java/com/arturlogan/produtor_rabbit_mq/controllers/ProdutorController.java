package com.arturlogan.produtor_rabbit_mq.controllers;

import com.arturlogan.produtor_rabbit_mq.entities.Produtor;
import com.arturlogan.produtor_rabbit_mq.services.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/produtor")
public class ProdutorController {

    private final ProdutorService produtorService;

    @GetMapping
    public ResponseEntity<List<Produtor>> listarTodos(){
        List<Produtor> produtorList = produtorService.listarTodos();

        return ResponseEntity.ok().body(produtorList);
    }

    @PostMapping
    public ResponseEntity<Produtor> salvar(@RequestBody Produtor produtor){

        Produtor produtorSalvo = produtorService.salvar(produtor);

        return ResponseEntity.ok().body(produtorSalvo);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Produtor> buscar(@PathVariable UUID uuid){
        Produtor produtor = produtorService.buscar(uuid);

        return ResponseEntity.ok().body(produtor);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletar(@PathVariable UUID uuid){

        produtorService.deletar(uuid);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Produtor> atualizar(@PathVariable UUID uuid, @RequestBody Produtor produtor){
        Produtor produtorAtt = produtorService.atualizar(uuid, produtor);

        return ResponseEntity.ok().body(produtorAtt);
    }
}
