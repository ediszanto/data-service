package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.exception.CsvFileReadException;
import com.microservices.bootcamp.rds.model.Client;
import com.microservices.bootcamp.rds.model.FileUploadResponse;
import com.microservices.bootcamp.rds.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@Component
@Slf4j
public class ClientsApiDelegateImpl implements ClientsApiDelegate{

    private final ClientService clientService;

    @Autowired
    public ClientsApiDelegateImpl(ClientService clientUploadService) {
        this.clientService = clientUploadService;
    }

    @Override
    public ResponseEntity<Client> clientsClientIdGet(Long clientId) {
        Client result = clientService.clientsClientIdGet(clientId);
        if (isNull(result)) return notFound().build();
        return ok(result);
    }

    @Override
    public ResponseEntity<Client> clientsClientIdPut(Long clientId, Client client) {
        Client result = clientService.clientsClientIdPut(clientId, client);
        return ok(result);
    }

    @Override
    public ResponseEntity<FileUploadResponse> clientsFileUploadPost(MultipartFile file) {
        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        try{
            fileUploadResponse.setRecordsProcessedCount((int)clientService.clientFileUpload(file));
        } catch (CsvFileReadException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(fileUploadResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Client> clientsPost(Client model) {
        Client result = clientService.cleintPost(model);
        return status(CREATED).body(result);
    }
}
