package com.microservices.bootcamp.rds.service;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.Data;

import java.util.Date;

@Data
public class ClientCsvLine {
    @CsvBindByPosition(position = 0)
    private Long clientNumber;

    @CsvBindByPosition(position = 1)
    private String firstName;

    @CsvBindByPosition(position = 2)
    private String lastName;

    @CsvDate("yyyy-MM-dd")
    @CsvBindByPosition(position = 3)
    private Date contractDate;

    @CsvBindByPosition(position = 4)
    private String address;
}
