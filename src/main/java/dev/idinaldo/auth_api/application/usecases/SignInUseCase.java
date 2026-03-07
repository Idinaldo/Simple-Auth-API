package dev.idinaldo.auth_api.application.usecases;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
import org.apache.coyote.BadRequestException;

public interface SignInUseCase {
    String signIn(IdentityRequestDTO identityRequestDTO) throws BadRequestException;
}
