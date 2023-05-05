CREATE TABLE IF NOT EXISTS clients(
    client_number bigint NOT NULL PRIMARY KEY,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    contract_date date,
    address varchar(200),
    type varchar(7) NOT NULL,
    CHECK (LENGTH(address)>3)
);