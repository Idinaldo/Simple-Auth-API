package dev.idinaldo.auth_api.application.usecases;

import dev.idinaldo.auth_api.domain.models.Identity;
import org.apache.coyote.BadRequestException;

public interface SignInUseCase {
    String signIn(Identity identity) throws BadRequestException;
}
