package dev.idinaldo.auth_api.infrastructure.exceptions;

public class InvalidUsernameException extends RuntimeException {

    public InvalidUsernameException() {
        super("Invalid Username. Please make sure your username contain only letters (a-z and A-Z), numbers (0-9) and _ (underscore).");
    }
}
