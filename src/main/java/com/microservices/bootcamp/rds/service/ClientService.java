package com.microservices.bootcamp.rds.service;

import com.microservices.bootcamp.rds.exception.CsvFileReadException;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
@Slf4j
public class ClientService {
    public long clientFileUpload(MultipartFile csvFile) throws CsvFileReadException {
        try (Reader reader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()))){
            return new CsvToBeanBuilder(reader)
                    .withType(ClientsCsvLine.class)
                    .build()
                    .stream()
                    .map(clientLine -> {
                        log.debug("Client line: {}", clientLine);
                        return clientLine;
                    })
                    .count();
        } catch(IOException e) {
            throw new CsvFileReadException("unable to read client csv file");
        }
    }
}
