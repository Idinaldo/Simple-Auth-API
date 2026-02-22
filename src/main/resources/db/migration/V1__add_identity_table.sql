CREATE TABLE identity(
    id UUID PRIMARY KEY,
    username VARCHAR(16) NOT NULL UNIQUE,
    password_hash VARCHAR(72) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);