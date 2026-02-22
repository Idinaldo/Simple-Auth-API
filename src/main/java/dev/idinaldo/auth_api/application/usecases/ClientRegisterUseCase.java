package dev.idinaldo.auth_api.application.usecases;

import dev.idinaldo.auth_api.adapters.in.dtos.ClientIdentityRegisterDTO;
import dev.idinaldo.auth_api.domain.models.Identity;

public interface ClientRegisterUseCase {

    void registerClient(Identity identity);
}
