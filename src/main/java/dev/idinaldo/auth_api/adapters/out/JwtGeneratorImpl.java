package dev.idinaldo.auth_api.adapters.out;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.ports.JwtGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Arrays;

@Component
public class JwtGeneratorImpl implements JwtGenerator {

    @Value("${api.security.token.secret}")
    private String secret;

    @Override
    public String generateToken(Identity identity) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("dev.idinaldo.auth-api")
                    .withSubject(identity.getUsername())
                    .withIssuedAt(Instant.now())
                    .withClaim("roles", Arrays.asList(identity.getRoles()))
                    .withExpiresAt(this.getExpirationDate())
                    .sign(algorithm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "token";
    }

    private Instant getExpirationDate() {
        return LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00"));
    }
}
