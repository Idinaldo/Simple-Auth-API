package dev.idinaldo.auth_api.ports;

import dev.idinaldo.auth_api.domain.models.Identity;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepository {
    void save(Identity identity);
}
