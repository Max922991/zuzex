CREATE TABLE license
(
    id            UUID PRIMARY KEY,
    driver_id    UUID REFERENCES driver (id),
    license_start DATE,
    license_end   DATE
);