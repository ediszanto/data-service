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
        return ClientsApiDelegate.super.clientsClientIdGet(clientId);
    }

    @Override
    public ResponseEntity<Client> clientsClientIdPut(Long clientId, Client client) {
        return ClientsApiDelegate.super.clientsClientIdPut(clientId, client);
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
    public ResponseEntity<Client> clientsPost(Client client) {
        log.debug("Creating new Client --> {} ", client);
//        return ClientsApiDelegate.super.clientsPost(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
}
