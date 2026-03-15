package dev.idinaldo.auth_api.application.usecases;

import dev.idinaldo.auth_api.adapters.out.dtos.RegisterResponseDTO;
import dev.idinaldo.auth_api.domain.models.Identity;


public interface ClientRegisterUseCase {

    RegisterResponseDTO registerClient(Identity identity);
}
