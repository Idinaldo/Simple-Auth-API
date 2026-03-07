package dev.idinaldo.auth_api.adapters.out.persistence;

import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.entities.JpaIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IdentityJpaRepository extends JpaRepository<JpaIdentity, UUID> {
    Optional<JpaIdentity> findByUsername(String username);
}
