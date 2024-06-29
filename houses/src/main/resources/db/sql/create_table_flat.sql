CREATE TABLE flat
(
    id          UUID PRIMARY KEY,
    address_id  UUID NOT NULL REFERENCES address_house (id),
    flat_number VARCHAR(8)
);
