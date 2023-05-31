package com.microservices.bootcamp.rds.service;

import com.microservices.bootcamp.rds.entity.ClientEntity;
import com.microservices.bootcamp.rds.exception.CsvFileReadException;
import com.microservices.bootcamp.rds.model.Client;
import com.microservices.bootcamp.rds.model.Contract;
import com.microservices.bootcamp.rds.repository.ClientRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Objects;

import static com.microservices.bootcamp.rds.entity.ClientMapper.CLIENT_MAPPER;
import static java.util.Objects.nonNull;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ContractService contractService;

    public long clientFileUpload(MultipartFile csvFile) throws CsvFileReadException {
        List<ClientEntity> clients = fetchClientsFromCsvFile(csvFile);
        return clientRepository.saveAll(clients).size();
    }

    private static List<ClientEntity> fetchClientsFromCsvFile(MultipartFile csvFile) throws CsvFileReadException {
        try (Reader reader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()))){
            return new CsvToBeanBuilder<ClientCsvLine>(reader)
                    .withType(ClientCsvLine.class)
                    .build()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(CLIENT_MAPPER::fromCSVModel)
                    .toList();
        } catch(IOException e) {
            throw new CsvFileReadException("unable to read client csv file");
        }
    }

    @Transactional
    public Client cleintPost(Client clientModel) {
        ClientEntity clientEntity = clientRepository.save(CLIENT_MAPPER.fromDto(clientModel));
        clientModel.setClientId(clientEntity.getClientId());

        Contract contractModel = contractService.saveContractForClient(clientModel);
        clientModel.setContract(contractModel);
        return clientModel;
    }


    @Transactional(readOnly = true)
    public Client clientsClientIdGet(Long clientId) {
        Client client = CLIENT_MAPPER.toDto(clientRepository.findByClientId(clientId));
        Contract contract = contractService.getContractByClientId(clientId);
        return client;
    }

    @Transactional
    public Client clientsClientIdPut(Long clientId, Client client) {
        ClientEntity entity = clientRepository.findByClientId(clientId);

        if (nonNull(entity)) CLIENT_MAPPER.update(client, entity);
        else entity = CLIENT_MAPPER.fromDto(client);

        Client updateClient = CLIENT_MAPPER.toDto(clientRepository.save(entity));
        client.setClientId(updateClient.getClientId());

        Contract contract = contractService.saveContractForClient(client);
        updateClient.setContract(contract);
        return updateClient;
    }
}
