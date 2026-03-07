package dev.idinaldo.auth_api.domain.models;

import java.util.UUID;

public class Identity {

    private UUID id;
    private String username;
    private String passwordHash;

    public Identity(UUID id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Identity(String username, String passwordHash) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String toString() {
        return "username=" + this.username + " id=" + this.id;
    }
}
