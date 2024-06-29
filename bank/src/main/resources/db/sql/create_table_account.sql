CREATE TABLE account
(
    id UUID PRIMARY KEY,
    citizen_id UUID,
    balance INT DEFAULT 0.0
);
