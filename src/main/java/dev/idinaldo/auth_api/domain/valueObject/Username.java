package dev.idinaldo.auth_api.domain.valueObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import dev.idinaldo.auth_api.infrastructure.exceptions.InvalidUsernameException;

public record Username(String username) {

    @JsonCreator
    public Username(String username) {
        if (this.isValid(username)) {
            this.username = username;
        } else {
            throw new InvalidUsernameException();
        }
    }

    private boolean isValid(String value) {
        System.out.println("[" + value + "]");
        System.out.println(value.matches("\\w{6,16}"));
        return value.matches("\\w{6,16}");
    }

    @JsonValue
    public String getValue() {
        return this.username;
    }
}
