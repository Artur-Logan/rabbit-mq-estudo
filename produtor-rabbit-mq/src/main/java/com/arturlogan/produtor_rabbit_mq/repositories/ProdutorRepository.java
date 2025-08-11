package com.arturlogan.produtor_rabbit_mq.repositories;

import com.arturlogan.produtor_rabbit_mq.entities.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, UUID> {
}
