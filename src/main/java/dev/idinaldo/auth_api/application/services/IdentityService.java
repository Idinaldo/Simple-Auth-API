package dev.idinaldo.auth_api.application.services;

import dev.idinaldo.auth_api.adapters.in.dtos.ClientIdentityRegisterDTO;
import dev.idinaldo.auth_api.application.usecases.ClientRegisterUseCase;
import dev.idinaldo.auth_api.domain.models.Identity;
import org.springframework.stereotype.Service;

@Service
public class IdentityService implements ClientRegisterUseCase {


    @Override
    public void registerClient(Identity identity) {

    }
}
