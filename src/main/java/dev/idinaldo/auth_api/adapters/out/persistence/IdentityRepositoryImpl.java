package dev.idinaldo.auth_api.adapters.out.persistence;

import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.entities.JpaIdentity;
import dev.idinaldo.auth_api.infrastructure.mappers.IdentityMapperFacade;
import dev.idinaldo.auth_api.ports.IdentityRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class IdentityRepositoryImpl implements IdentityRepository {

    private final IdentityJpaRepository identityJpaRepository;
    private final IdentityMapperFacade identityMapper;

    public IdentityRepositoryImpl(IdentityJpaRepository identityJpaRepository, IdentityMapperFacade identityMapper) {
        this.identityJpaRepository = identityJpaRepository;
        this.identityMapper = identityMapper;
    }

    @Override
    public UUID save(Identity identity) {
        JpaIdentity jpaIdentity = this.identityMapper.domainToEntity(identity);
        return this.identityJpaRepository.save(jpaIdentity).getId();
    }

    @Override
    public Identity findByUsername(String username) throws BadRequestException {
        JpaIdentity jpaIdentity = this.identityJpaRepository.findByUsername(username).orElseThrow(BadRequestException::new);
        return this.identityMapper.entityToDomain(jpaIdentity);
    }

    @Override
    public List<Identity> findAll() {
        return this.identityJpaRepository.findAll().stream().map(identityMapper::entityToDomain).toList();
    }
}
