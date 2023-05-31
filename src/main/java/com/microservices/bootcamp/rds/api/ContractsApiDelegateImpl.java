package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.model.Contract;
import com.microservices.bootcamp.rds.service.ContractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContractsApiDelegateImpl implements ContractsApiDelegate {

    private final ContractService contractService;

    @Override
    public ResponseEntity<Contract> contractsContractIdPut(Long contractId, Contract model) {
        Contract result = contractService.contratsContractIdPut(contractId, model);
        return ResponseEntity.ok(result);
    }
}
