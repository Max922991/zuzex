CREATE TABLE car
(
    id       UUID PRIMARY KEY,
    model    VARCHAR(16),
    mark     VARCHAR(16),
    color_id UUID REFERENCES color (id),
    price    INT
);