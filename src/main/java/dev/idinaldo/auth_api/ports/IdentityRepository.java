package dev.idinaldo.auth_api.ports;

import dev.idinaldo.auth_api.domain.models.Identity;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IdentityRepository {
    UUID save(Identity identity);
    Identity findByUsername(String username) throws BadRequestException;
}
