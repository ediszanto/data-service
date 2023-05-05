CREATE TABLE IF NOT EXISTS contracts(
    contract_id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_id bigint NOT NULL,
    CONSTRAINT fk_contracts_clients FOREIGN KEY (client_id) REFERENCES clients(client_id)
) AUTO_INCREMENT=1;