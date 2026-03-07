package dev.idinaldo.auth_api.adapters.in.controllers;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
import dev.idinaldo.auth_api.application.services.IdentityService;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.mappers.IdentityMapperFacade;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/auth")
public class IdentityController {

    private final IdentityService identityService;
    private final IdentityMapperFacade identityMapper;

    public IdentityController(IdentityService identityService, IdentityMapperFacade identityMapper) {
        this.identityService = identityService;
        this.identityMapper = identityMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerClient(@RequestBody @Valid IdentityRequestDTO identityRegisterDTO) {
        Identity identity = this.identityMapper.requestDtoToDomain(identityRegisterDTO);
        UUID id = this.identityService.registerClient(identity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Credentials registered successfully with ID: " + id);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody @Valid IdentityRequestDTO identityRequestDTO) throws BadRequestException {
        return ResponseEntity.ok(this.identityService.signIn(identityRequestDTO));
    }
}
