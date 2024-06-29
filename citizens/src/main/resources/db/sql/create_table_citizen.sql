CREATE TABLE citizen
(
    id        UUID PRIMARY KEY,
    name      VARCHAR(32),
    gender_id SMALLINT REFERENCES gender (id),
    birthday  DATE
);
