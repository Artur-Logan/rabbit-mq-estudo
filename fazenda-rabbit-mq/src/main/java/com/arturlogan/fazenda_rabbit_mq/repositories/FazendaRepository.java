package com.arturlogan.fazenda_rabbit_mq.repositories;

import com.arturlogan.fazenda_rabbit_mq.entities.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, UUID> {
    List<Fazenda> findByProdutorId(UUID produtorId);
}
