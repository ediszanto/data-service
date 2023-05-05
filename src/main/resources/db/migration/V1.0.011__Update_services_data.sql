
UPDATE services
SET comment = 'This is faster then the regular Internet Service'
WHERE code = 'AIS';

UPDATE services
SET comment = '24/7 Suppport line'
WHERE code = 'ACS';


UPDATE services
SET type = (
    CASE
        WHEN code = 'AIS' THEN 'SILVER'
        WHEN code = 'ACS' THEN 'GOLD'
        ELSE 'REGULAR'
    END
);
