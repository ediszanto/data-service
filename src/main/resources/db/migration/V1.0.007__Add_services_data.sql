DELETE FROM services
WHERE code in ('SMS', 'MMS', 'CAL', 'IS', 'AIS', 'CS', 'ACS');

INSERT INTO services(code, name, unit, price, vat) VALUES
('SMS', 'Short Message Service', 'SMS', 1, 0.05),
('MMS', 'Media Message Service', 'MMS', 2, 0.1),
('CAL', 'Phone Call', 'MIN', 0.4, 0.03),
('IS', 'Internet Service', 'MB', 1, 0.05),
('AIS', 'Advanced Internet Service', 'MB', 2, 0.1),
('CS', 'Customer Support', 'MIN', null, null),
('ACS', 'Advanced Customer Support', 'MIN', 0.5, 0.025);
