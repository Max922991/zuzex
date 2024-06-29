CREATE TABLE license
(
    id            UUID PRIMARY KEY,
    student_id    UUID REFERENCES student (id),
    license_start DATE
);