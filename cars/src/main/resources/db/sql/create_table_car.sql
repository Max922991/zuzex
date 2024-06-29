CREATE TABLE car
(
    id          UUID PRIMARY KEY,
    car_mark_id UUID REFERENCES car_mark (id),
    number_car  VARCHAR(16),
    citizen_id  UUID
);