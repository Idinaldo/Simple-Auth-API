package dev.idinaldo.auth_api.ports;

import dev.idinaldo.auth_api.domain.models.Identity;
import org.springframework.stereotype.Component;

@Component
public interface JwtGenerator {
    String generateToken(Identity identity);
    String validateToken(String token);
}
