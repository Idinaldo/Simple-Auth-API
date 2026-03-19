CREATE TABLE refresh_token (
    id UUID primary key,
    token varchar(36),
    expires_at TIMESTAMP,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    revoked TINYINT(1)
    user_id UUID
);