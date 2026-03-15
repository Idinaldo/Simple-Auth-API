package dev.idinaldo.auth_api.adapters.out;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.domain.valueObject.RoleName;
import dev.idinaldo.auth_api.ports.JwtGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class JwtGeneratorImpl implements JwtGenerator {

    @Value("${api.security.token.secret}")
    private String secret;

    @Override
    public String generateToken(Identity identity) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("dev.idinaldo.auth-api")
                    .withSubject(identity.getUsername())
                    .withIssuedAt(Instant.now())
                    .withClaim("roles", identity.getRoles().stream().map(RoleName::toString).toList())
                    .withExpiresAt(this.getExpirationDate())
                    .sign(algorithm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("dev.idinaldo.auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Instant getExpirationDate() {
        return LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00"));
    }
}
