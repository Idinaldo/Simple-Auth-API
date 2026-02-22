package dev.idinaldo.auth_api.application.usecases;

import dev.idinaldo.auth_api.adapters.in.dtos.ClientIdentityRegisterDTO;
import dev.idinaldo.auth_api.domain.models.Identity;

import java.util.UUID;

public interface ClientRegisterUseCase {

    UUID registerClient(Identity identity);
}
