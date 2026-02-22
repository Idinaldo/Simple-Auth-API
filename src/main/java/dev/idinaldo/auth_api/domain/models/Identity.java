package dev.idinaldo.auth_api.domain.models;

import dev.idinaldo.auth_api.domain.valueObject.Username;

import java.util.UUID;

public class Identity {

    private UUID id;
    private Username username;
    private String passwordHash;

    public Identity(UUID id, Username username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Identity(Username username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Identity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
