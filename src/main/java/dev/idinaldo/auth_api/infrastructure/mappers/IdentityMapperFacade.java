package dev.idinaldo.auth_api.infrastructure.mappers;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.entities.JpaIdentity;
import org.springframework.stereotype.Component;

@Component
public class IdentityMapperFacade {

    private final SimpleIdentityMapper simpleMapper;
    private final IdentityMapper complexMapper;

    public IdentityMapperFacade(SimpleIdentityMapper simpleMapper, IdentityMapper complexMapper) {
        this.simpleMapper = simpleMapper;
        this.complexMapper = complexMapper;
    }

    public Identity requestDtoToDomain(IdentityRequestDTO requestDTO) {
        return this.complexMapper.requestDtoToDomain(requestDTO);
    }

    public Identity entityToDomain(JpaIdentity jpaIdentity) {
        return this.simpleMapper.entityToDomain(jpaIdentity);
    }

    public JpaIdentity domainToEntity(Identity identity) {
        return this.simpleMapper.domainToEntity(identity);
    }

}
