package dev.idinaldo.auth_api.domain.models;

import dev.idinaldo.auth_api.domain.valueObject.RoleName;

import java.util.List;
import java.util.UUID;

public class Identity {

    private UUID id;
    private String username;
    private List<RoleName> roles = List.of(RoleName.CUSTOMER); // default value
    private String passwordHash;

    public Identity(UUID id, String username, List<RoleName> roles, String passwordHash) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.passwordHash = passwordHash;
    }

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

    public List<RoleName> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleName> roles) {
        this.roles = roles;
    }

    public String toString() {
        return "username=" + this.username + " id=" + this.id;
    }
}
