package dev.idinaldo.auth_api.infrastructure.mappers;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
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

    public Identity requestDtoToDomain(IdentityRequestDTO identityRegisterDTO) {
        return new Identity(identityRegisterDTO.username(), identityRegisterDTO.password());
    }

    public JpaIdentity domainToEntity(Identity identity) {
        JpaIdentity jpaIdentity = new JpaIdentity();

        jpaIdentity.setUsername(identity.getUsername().getValue());
        jpaIdentity.setPasswordHash(this.passwordEncoder.encode(identity.getPassword()));

        return jpaIdentity;
    }

    public Identity entityToDomain(JpaIdentity jpaIdentity) {
        Identity identity = new Identity();

        identity.setId(jpaIdentity.getId());
        identity.setUsernameFromString(jpaIdentity.getUsername());

        return identity;
    }

}
