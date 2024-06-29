CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO car(id, model, mark, color_id, price)
VALUES (uuid_generate_v4(), 'toyota', 'camry edition', (SELECT id FROM color WHERE color.title = 'black'), 3500000),
       (uuid_generate_v4(), 'land', 'crouser 400', (SELECT id FROM color WHERE color.title = 'white'), 4500000);