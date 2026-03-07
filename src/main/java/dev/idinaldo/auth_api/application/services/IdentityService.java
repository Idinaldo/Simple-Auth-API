package dev.idinaldo.auth_api.application.services;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
import dev.idinaldo.auth_api.application.usecases.ClientRegisterUseCase;
import dev.idinaldo.auth_api.application.usecases.SignInUseCase;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.ports.IdentityRepository;
import dev.idinaldo.auth_api.ports.JwtGenerator;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdentityService implements ClientRegisterUseCase, SignInUseCase {

    private final IdentityRepository identityRepository;
    private final JwtGenerator jwtGenerator;
    private final PasswordEncoder passwordEncoder;
    private final String SIGN_IN_ERROR_MESSAGE = "Please verify your request.";
    private final Logger logger = LoggerFactory.getLogger(IdentityService.class);

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
    public String signIn(IdentityRequestDTO identityRequestDTO) throws BadRequestException {
        Identity persistedIdentity = identityRepository.findByUsername(identityRequestDTO.username());
        if (passwordEncoder.matches(identityRequestDTO.password(), persistedIdentity.getPasswordHash())) {
            return this.jwtGenerator.generateToken(persistedIdentity);
        } else throw new BadRequestException(SIGN_IN_ERROR_MESSAGE);
    }
}
