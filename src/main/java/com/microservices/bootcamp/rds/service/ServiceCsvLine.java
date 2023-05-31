package com.microservices.bootcamp.rds.service;

import com.microservices.bootcamp.rds.entity.ServiceMapper;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class ServiceCsvLine {

    @CsvBindByPosition(position = 0)
    private String code;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String unit;
}
