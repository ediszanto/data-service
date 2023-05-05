CREATE TABLE IF NOT EXISTS services(
    code varchar(3) NOT NULL PRIMARY KEY,
    name varchar(100) NOT NULL,
    unit varchar(3) NOT NULL,
    price numeric(14, 2),
    vat numeric(14, 2)
);