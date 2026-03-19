package dev.idinaldo.auth_api.ports;

import org.springframework.stereotype.Component;

@Component
public interface RandomStringGenerator {
    String generateRandomString();
}
