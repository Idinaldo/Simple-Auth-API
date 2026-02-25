package dev.idinaldo.auth_api.domain.models;

import dev.idinaldo.auth_api.domain.valueObject.Username;

import java.util.UUID;

public class Identity {

    private UUID id;
    private Username username;
    private String password;

    public Identity(UUID id, Username username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Identity(Username username, String password) {
        this.username = username;
        this.password = password;
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

    public void setUsernameFromString(String username) {
        this.username = new Username(username);
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "username=" + this.username + " id=" + this.id;
    }
}
