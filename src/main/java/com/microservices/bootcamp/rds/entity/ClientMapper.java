package com.microservices.bootcamp.rds.entity;

import com.microservices.bootcamp.rds.model.Client;
import com.microservices.bootcamp.rds.service.ClientCsvLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper CLIENT_MAPPER = Mappers.getMapper(ClientMapper.class);

    ClientEntity fromDto(Client dto);

    Client toDto(ClientEntity entity);

    @Mapping(target = "clientId", ignore = true)
    void update(Client client, @MappingTarget ClientEntity entity);

    ClientEntity fromCSVModel(ClientCsvLine csvLine);
}
