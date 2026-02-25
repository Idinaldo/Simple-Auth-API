package dev.idinaldo.auth_api.application.services;

import dev.idinaldo.auth_api.application.usecases.ClientRegisterUseCase;
import dev.idinaldo.auth_api.application.usecases.SignInUseCase;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.entities.JpaIdentity;
import dev.idinaldo.auth_api.ports.IdentityRepository;
import dev.idinaldo.auth_api.ports.JwtGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdentityService implements ClientRegisterUseCase, SignInUseCase {

    private final IdentityRepository identityRepository;
    private final JwtGenerator jwtGenerator;
    private final PasswordEncoder passwordEncoder;

    public IdentityService(IdentityRepository identityRepository, JwtGenerator jwtGenerator, PasswordEncoder passwordEncoder) {
        this.identityRepository = identityRepository;
        this.jwtGenerator = jwtGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UUID registerClient(Identity identity) {
        return this.identityRepository.save(identity);
    }

    @Override
    public String signIn(Identity identity) {

        if (passwordEncoder.matches(identity.getPassword(), userCredentials.getPassword()))
        return "";
    }
}
