package dev.idinaldo.auth_api.application.services;

import dev.idinaldo.auth_api.adapters.in.dtos.ClientIdentityRegisterDTO;
import dev.idinaldo.auth_api.application.usecases.ClientRegisterUseCase;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.ports.IdentityRepository;
import org.springframework.stereotype.Service;

@Service
public class IdentityService implements ClientRegisterUseCase {

    private final IdentityRepository identityRepository;

    public IdentityService(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    @Override
    public void registerClient(Identity identity) {
        this.identityRepository.save(identity);
    }
}
