package dev.idinaldo.auth_api.infrastructure.exceptions;

public class WeakPasswordException extends RuntimeException {

    public WeakPasswordException() {
        super("Please make sure your password is at least 6-characters long and contains letters, numbers and special symbols.");
    }

    public WeakPasswordException(String message) {
        super(message);
    }
}
