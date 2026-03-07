package dev.idinaldo.auth_api.infrastructure.mappers;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
import dev.idinaldo.auth_api.domain.models.Identity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class IdentityMapper {

    private final PasswordEncoder passwordEncoder;

    public IdentityMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Identity requestDtoToDomain(IdentityRequestDTO identityRegisterDTO) {
        return new Identity(
                identityRegisterDTO.username(),
                this.passwordEncoder.encode(identityRegisterDTO.password())
        );
    }

}
