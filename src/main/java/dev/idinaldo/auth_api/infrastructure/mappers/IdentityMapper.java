package dev.idinaldo.auth_api.infrastructure.mappers;

import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.entities.JpaIdentity;
import org.springframework.stereotype.Component;

@Component
public class IdentityMapper {

    public JpaIdentity domainToEntity(Identity identity) {
        JpaIdentity jpaIdentity = new JpaIdentity();

        jpaIdentity.setUsername(identity.getUsername().getValue());
        jpaIdentity.setPasswordHash(identity.getPasswordHash());

        return jpaIdentity;
    }
}
