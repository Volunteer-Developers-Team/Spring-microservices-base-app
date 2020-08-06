-- Table Schemas
DROP TABLE IF EXISTS sample;

CREATE TABLE sample(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    sample_str_1 VARCHAR(50) NOT NULL,
    sample_str_2 VARCHAR(50)
);

-- Sample initial test datas
-- Data 4 str 2 was put to Data 5 as well to test repo getByStr2 api
INSERT INTO sample (sample_str_1, sample_str_2) VALUES  ('Data 1 : Test Service Str 1', 'Data 1 : Test Service Str 2'),
                                                        ('Data 2 : Test Service Str 1', 'Data 2 : Test Service Str 2'),
                                                        ('Data 3 : Test Service Str 1', null ),
                                                        ('Data 4 : Test Service Str 1', 'Data 4 : Test Service Str 2'),
                                                        ('Data 5 : Test Service Str 1', 'Data 4 : Test Service Str 2'),
                                                        ('Data 6 : Test Service Str 1', null );
