CREATE TABLE car_mark
(
    id    UUID PRIMARY KEY,
    mark  VARCHAR(32),
    model VARCHAR(32),
    UNIQUE (mark, model)
);