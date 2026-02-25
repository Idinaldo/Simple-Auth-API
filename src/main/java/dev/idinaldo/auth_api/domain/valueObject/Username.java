package dev.idinaldo.auth_api.domain.valueObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import dev.idinaldo.auth_api.infrastructure.exceptions.InvalidUsernameException;

public record Username(String value) {


    @JsonCreator
    public Username(String value) {
        if (this.isValid(value)) {
            this.value = value;
        } else {
            throw new InvalidUsernameException();
        }
    }

    private boolean isValid(String value) {
        return value.matches("\\w{6,16}");
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }
}
