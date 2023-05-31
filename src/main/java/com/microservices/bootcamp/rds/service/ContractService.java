package com.microservices.bootcamp.rds.service;

import com.microservices.bootcamp.rds.entity.ContractDetailsEntity;
import com.microservices.bootcamp.rds.entity.ContractEntity;
import com.microservices.bootcamp.rds.entity.ContractMapper;
import com.microservices.bootcamp.rds.model.Client;
import com.microservices.bootcamp.rds.model.Contract;
import com.microservices.bootcamp.rds.model.Service;
import com.microservices.bootcamp.rds.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.microservices.bootcamp.rds.entity.ContractDetailsMapper.CONTRACT_DETAILS_MAPPER;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toSet;

@Component
@RequiredArgsConstructor
public class ContractService {

    private final ContractMapper contractMapper;
    private final ContractRepository contractRepository;
    private final ServicesService servicesService;

    public Contract saveContractForClient(Client clientModel) {
        ContractEntity contractEntity =  contractRepository.findByClientClientId(clientModel.getClientId());
        if (nonNull(contractEntity)) contractMapper.update(clientModel.getContract(), contractEntity);
        else contractMapper.toEntity(clientModel);
        Set<ContractDetailsEntity> contractDetails = generateContractDetails(clientModel);
        contractEntity.setRegistrations(contractDetails);

        return contractMapper.toDto(contractRepository.save(contractEntity));
    }

    private Set<ContractDetailsEntity> generateContractDetails(Client clientModel) {
        return servicesService.servicesServicesCodesGet(extractServicesCodes(clientModel))
                .stream()
                .map(s -> CONTRACT_DETAILS_MAPPER.toEntity(clientModel.getContract(), s))
                .collect(toSet());
    }

    private Set<String> extractServicesCodes(Client clientModel) {
        return clientModel.getContract().getServices()
                .stream()
                .map(com.microservices.bootcamp.rds.model.Service::getCode)
                .collect(toSet());
    }

    public Contract getContractByClientId(Long clientId) {
        ContractEntity contractEntity = contractRepository.findByClientClientId(clientId);
        return contractMapper.toDto(contractEntity);
    }

    @Transactional
    public Contract contratsContractIdPut(Long contractId, Contract contract) {
        ContractEntity contractEntity = contractRepository.findByContractId(contractId);
        if (nonNull(contractEntity)) throw new IllegalArgumentException("Invalid contract info");

        Set<ContractDetailsEntity> collect =
                servicesService.servicesServicesCodesGet(contract.getServices().stream().map(Service::getCode).collect(toSet()))
                .stream().map(service -> CONTRACT_DETAILS_MAPPER.toEntity(contract, service))
                .collect(toSet());

        contractEntity.setRegistrations(collect);

        contractMapper.update(contract, contractEntity);
        contractEntity = contractRepository.save(contractEntity);
        return contractMapper.toDto(contractEntity);
    }
}
