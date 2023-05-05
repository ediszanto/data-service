CREATE TABLE IF NOT EXISTS contract_details(
    contract_details_id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    contract_id bigint NOT NULL,
    service_id bigint NOT NULL,
   CONSTRAINT fk_contract_details_contracts FOREIGN KEY (contract_id) REFERENCES contracts(contract_id),
   CONSTRAINT fk_contract_details_services FOREIGN KEY (service_id) REFERENCES services(service_id)
) AUTO_INCREMENT=1;