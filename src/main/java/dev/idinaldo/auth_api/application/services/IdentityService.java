package dev.idinaldo.auth_api.application.services;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
import dev.idinaldo.auth_api.adapters.out.dtos.RefreshTokenResponseDTO;
import dev.idinaldo.auth_api.adapters.out.dtos.RegisterResponseDTO;
import dev.idinaldo.auth_api.adapters.out.dtos.AccessTokenDTO;
import dev.idinaldo.auth_api.application.usecases.ClientRegisterUseCase;
import dev.idinaldo.auth_api.application.usecases.RefreshUseCase;
import dev.idinaldo.auth_api.application.usecases.SignInUseCase;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.ports.IdentityRepository;
import dev.idinaldo.auth_api.ports.JwtGenerator;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class IdentityService implements ClientRegisterUseCase, SignInUseCase, RefreshUseCase {

    private final IdentityRepository identityRepository;
    private final JwtGenerator jwtGenerator;
    private final PasswordEncoder passwordEncoder;
    private final String DEFAULT_ERROR_MESSAGE = "Please verify your request.";
    private final Logger logger = LoggerFactory.getLogger(IdentityService.class);

    public IdentityService(IdentityRepository identityRepository, JwtGenerator jwtGenerator, PasswordEncoder passwordEncoder) {
        this.identityRepository = identityRepository;
        this.jwtGenerator = jwtGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterResponseDTO registerClient(Identity identity) {
        return new RegisterResponseDTO(this.identityRepository.save(identity));
    }

    @Override
    public AccessTokenDTO signIn(IdentityRequestDTO identityRequestDTO) throws BadRequestException {
        Identity persistedIdentity = identityRepository.findByUsername(identityRequestDTO.username());
        if (passwordEncoder.matches(identityRequestDTO.password(), persistedIdentity.getPasswordHash())) {
            return new AccessTokenDTO(this.jwtGenerator.generateToken(persistedIdentity));
        } else throw new BadRequestException(DEFAULT_ERROR_MESSAGE);
    }

    @Override
    public RefreshTokenResponseDTO refreshToken(Identity identity) {

        // verificar refresh token atual
            // invalidar refresh token atual
            // gerar novo access token
            // gerar novo refresh token
            // persistir novo refresh token
            // retornar RefreshTokenResponseDTO
        // retornar InvalidRefreshTokenException

        return new RefreshTokenResponseDTO("AccessToken", "RefreshToken");
    }
}
