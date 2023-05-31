package com.microservices.bootcamp.rds.repository;

import com.microservices.bootcamp.rds.entity.ServiceEntity;
import com.microservices.bootcamp.rds.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    Set<ServiceEntity> findByCodeIn(Set<String> codes);

    ServiceEntity findByServiceId(Long serviceId);
}
