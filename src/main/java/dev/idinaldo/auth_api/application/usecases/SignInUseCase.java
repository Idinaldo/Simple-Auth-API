package dev.idinaldo.auth_api.application.usecases;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
import dev.idinaldo.auth_api.adapters.out.dtos.SignInResponseDTO;
import org.apache.coyote.BadRequestException;

public interface SignInUseCase {
    SignInResponseDTO signIn(IdentityRequestDTO identityRequestDTO) throws BadRequestException;
}
