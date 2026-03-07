package dev.idinaldo.auth_api.infrastructure.mappers;

import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.entities.JpaIdentity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimpleIdentityMapper {

    Identity entityToDomain(JpaIdentity jpaIdentity);
    JpaIdentity domainToEntity(Identity identity);
}
