package com.microservices.bootcamp.rds.entity;

import com.microservices.bootcamp.rds.model.Service;
import com.microservices.bootcamp.rds.service.ServiceCsvLine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceMapper {

    ServiceMapper SERVICE_MAPPER = Mappers.getMapper(ServiceMapper.class);

    Service toDto(ServiceEntity entity);

    ServiceEntity fromCsvModel(ServiceCsvLine csvLine);
}
