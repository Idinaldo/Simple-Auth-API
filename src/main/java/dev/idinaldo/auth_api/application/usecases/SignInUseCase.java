package dev.idinaldo.auth_api.application.usecases;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
import dev.idinaldo.auth_api.adapters.out.dtos.AccessTokenDTO;
import org.apache.coyote.BadRequestException;

public interface SignInUseCase {
    AccessTokenDTO signIn(IdentityRequestDTO identityRequestDTO) throws BadRequestException;
}
