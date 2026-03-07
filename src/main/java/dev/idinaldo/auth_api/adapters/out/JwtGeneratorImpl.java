package dev.idinaldo.auth_api.adapters.out;

import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.ports.JwtGenerator;
import org.springframework.stereotype.Component;

@Component
public class JwtGeneratorImpl implements JwtGenerator {

    @Override
    public String generateToken(Identity identity) {
        return "token";
    }
}
