package com.microservices.bootcamp.rds.entity;

import com.microservices.bootcamp.rds.model.Contract;
import com.microservices.bootcamp.rds.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractDetailsMapper {

    ContractDetailsMapper CONTRACT_DETAILS_MAPPER = Mappers.getMapper(ContractDetailsMapper.class);

//    @Mapping(target = "contract", source = "contract")
    @Mapping(target = "service", source = "service")
    @Mapping(target = "registrationDate", source = "contract.contractDate")
    ContractDetailsEntity toEntity(Contract contract, Service service);
}
