package dev.idinaldo.auth_api.adapters.in.dtos;

import dev.idinaldo.auth_api.domain.valueObject.Username;

public record ClientIdentityRegisterDTO(Username username, String password) {
}
