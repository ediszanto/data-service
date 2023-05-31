package com.microservices.bootcamp.rds.repository;

import com.microservices.bootcamp.rds.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByClientId(Long clientId);
}

