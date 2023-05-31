package com.microservices.bootcamp.rds.repository;

import com.microservices.bootcamp.rds.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
    ContractEntity findByClientClientId(Long clientId);

    ContractEntity findByContractId(Long contractId);
}
