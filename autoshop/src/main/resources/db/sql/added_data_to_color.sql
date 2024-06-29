CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
INSERT INTO color(id, title)
VALUES (uuid_generate_v4(), 'black'),
       (uuid_generate_v4(), 'white');