package dev.idinaldo.auth_api.application.services;

import dev.idinaldo.auth_api.application.usecases.ClientRegisterUseCase;
import dev.idinaldo.auth_api.application.usecases.SignInUseCase;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.entities.JpaIdentity;
import dev.idinaldo.auth_api.ports.IdentityRepository;
import dev.idinaldo.auth_api.ports.JwtGenerator;
import org.apache.coyote.BadRequestException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class IdentityService implements ClientRegisterUseCase, SignInUseCase {

    private final IdentityRepository identityRepository;
    private final JwtGenerator jwtGenerator;
    private final PasswordEncoder passwordEncoder;
    private final String SIGN_IN_ERROR_MESSAGE = "Please verify your request.";

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
    public String signIn(Identity identity) throws BadRequestException {

        // verificar se o usuário está cadastrado
        Identity persistedIdentity = identityRepository.findByUsername(identity.getUsername().getValue())
                .orElseThrow(() -> new BadRequestException(SIGN_IN_ERROR_MESSAGE));
        // verificar se a senha está correta
        if (passwordEncoder.matches(identity.getPassword(), persistedIdentity.getPassword())) {
            // gerar e retornar JWT
            return this.jwtGenerator.generateToken(persistedIdentity);
        } else {
            throw new BadRequestException(SIGN_IN_ERROR_MESSAGE);
        }
    }
}
