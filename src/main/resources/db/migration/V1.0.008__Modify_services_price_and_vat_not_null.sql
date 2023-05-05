
UPDATE services
SET price = 0
WHERE price is NULL;

UPDATE services
SET vat = 0
WHERE vat is NULL;

ALTER TABLE services
MODIFY COLUMN price numeric(14, 2) NOT NULL DEFAULT '0',
MODIFY COLUMN vat numeric(14, 2) NOT NULL DEFAULT '0';
