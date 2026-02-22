package dev.idinaldo.auth_api.adapters.out.persistence;

import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.entities.JpaIdentity;
import dev.idinaldo.auth_api.infrastructure.mappers.IdentityMapper;
import dev.idinaldo.auth_api.ports.IdentityRepository;
import org.springframework.stereotype.Component;

@Component
public class IdentityRepositoryImpl implements IdentityRepository {

    private final IdentityJpaRepository identityJpaRepository;
    private final IdentityMapper identityMapper;

    public IdentityRepositoryImpl(IdentityJpaRepository identityJpaRepository, IdentityMapper identityMapper) {
        this.identityJpaRepository = identityJpaRepository;
        this.identityMapper = identityMapper;
    }

    @Override
    public void save(Identity identity) {
        JpaIdentity jpaIdentity = this.identityMapper.domainToEntity(identity);
        this.identityJpaRepository.save(jpaIdentity);
    }
}
