package dev.idinaldo.auth_api.domain.valueObject;

import dev.idinaldo.auth_api.infrastructure.exceptions.InvalidUsernameException;

public record Username(String value) {

    public Username(String value) {
        if (this.isValid(value)) {
            this.value = value;
        }
        throw new InvalidUsernameException();
    }

    private boolean isValid(String value) {
        return value.matches("\\w{6,16}");
    }

    public String getValue() {
        return this.value;
    }
}
