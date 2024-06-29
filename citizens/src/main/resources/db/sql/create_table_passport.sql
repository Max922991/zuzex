CREATE TABLE passport
(
    id              UUID PRIMARY KEY,
    citizen_id      UUID REFERENCES citizen (id),
    address_flat_id UUID,
    number          VARCHAR(16),
    series          VARCHAR(16),
    UNIQUE (number, series)
);