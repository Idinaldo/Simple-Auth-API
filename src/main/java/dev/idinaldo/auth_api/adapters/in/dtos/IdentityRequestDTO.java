package dev.idinaldo.auth_api.adapters.in.dtos;


import dev.idinaldo.auth_api.infrastructure.exceptions.InvalidUsernameException;
import dev.idinaldo.auth_api.infrastructure.exceptions.WeakPasswordException;

public record IdentityRequestDTO(String username, String password) {

    public IdentityRequestDTO(String username, String password) {
        if (this.isUsernameValid(username)) {
            if (this.isPasswordValid(password)) {
                this.username = username;
                this.password = password;
            } else throw new WeakPasswordException();
        } else throw new InvalidUsernameException();
    }

    public boolean isUsernameValid(String username) {
        return true;
    }

    public boolean isPasswordValid(String password) {
        return true;
    }
}
