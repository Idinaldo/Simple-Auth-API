package dev.idinaldo.auth_api.application.usecases;

import dev.idinaldo.auth_api.domain.models.Identity;

public interface SignInUseCase {
    String signIn(Identity identity);
}
