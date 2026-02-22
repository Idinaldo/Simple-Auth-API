package dev.idinaldo.auth_api.infrastructure.mappers;

import dev.idinaldo.auth_api.adapters.in.dtos.ClientIdentityRegisterDTO;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.entities.JpaIdentity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class IdentityMapper {

    private final PasswordEncoder passwordEncoder;

    public IdentityMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public JpaIdentity domainToEntity(Identity identity) {
        JpaIdentity jpaIdentity = new JpaIdentity();

        jpaIdentity.setUsername(identity.getUsername().getValue());
        jpaIdentity.setPasswordHash(identity.getPasswordHash());

        return jpaIdentity;
    }

    public Identity registerDtoToDomain(ClientIdentityRegisterDTO identityRegisterDTO) {
        Identity identity = new Identity();

        identity.setUsername(identityRegisterDTO.username());
        identity.setPasswordHash(passwordEncoder.encode(identityRegisterDTO.password()));

        return identity;
    }
}
