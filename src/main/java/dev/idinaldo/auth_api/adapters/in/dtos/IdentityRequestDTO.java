package dev.idinaldo.auth_api.adapters.in.dtos;

import dev.idinaldo.auth_api.domain.valueObject.Username;

public record IdentityRequestDTO(Username username, String password) {
}
