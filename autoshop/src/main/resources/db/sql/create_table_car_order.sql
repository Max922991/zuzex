CREATE TABLE car_order
(
    id                             UUID PRIMARY KEY,
    status_order_id                SMALLINT REFERENCES status_order (id),
    bank_status_order_confirm_id   SMALLINT REFERENCES status_order_confirm (id),
    police_status_order_confirm_id SMALLINT REFERENCES status_order_confirm (id),
    price                          INT,
    citizen_id                     UUID,
    car_id                         UUID REFERENCES car (id)
);