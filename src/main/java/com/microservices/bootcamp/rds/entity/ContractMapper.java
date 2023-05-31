package com.microservices.bootcamp.rds.entity;

import com.microservices.bootcamp.rds.model.Client;
import com.microservices.bootcamp.rds.model.Contract;
import com.microservices.bootcamp.rds.model.Service;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collectors;

import static com.microservices.bootcamp.rds.entity.ServiceMapper.SERVICE_MAPPER;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ContractMapper {
    default Set<Service> toServices(ContractEntity contractEntity) {
        return contractEntity.getRegistrations()
                .stream()
                .map(ContractDetailsEntity::getService)
                .map(SERVICE_MAPPER::toDto)
                .collect(Collectors.toSet());
    }

    @Mapping(source = "contractEntity.contractId", target = "contractId")
    @Mapping(source = "contractEntity.contractDate", target = "contractDate")
    @Mapping(expression = "java(toServices(contractEntity))", target = "services")
    Contract toDto(ContractEntity contractEntity);

    @Mapping(target = "contractDate", source = "clientModel.contract.contractDate")
    @Mapping(target = "client", source = "clientModel")
    ContractEntity toEntity(Client clientModel);

    @Mapping(target = "contractId", ignore = true)
    void update(Contract contract, @MappingTarget ContractEntity contractEntity);
}
