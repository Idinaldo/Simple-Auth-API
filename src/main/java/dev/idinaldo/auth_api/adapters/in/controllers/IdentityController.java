package dev.idinaldo.auth_api.adapters.in.controllers;

import dev.idinaldo.auth_api.adapters.in.dtos.IdentityRequestDTO;
import dev.idinaldo.auth_api.adapters.out.dtos.RegisterResponseDTO;
import dev.idinaldo.auth_api.adapters.out.dtos.SignInResponseDTO;
import dev.idinaldo.auth_api.application.services.IdentityService;
import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.infrastructure.mappers.IdentityMapperFacade;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class IdentityController {

    private final IdentityService identityService;
    private final IdentityMapperFacade identityMapper;
    private final Logger logger = LoggerFactory.getLogger(IdentityController.class);

    public IdentityController(IdentityService identityService, IdentityMapperFacade identityMapper) {
        this.identityService = identityService;
        this.identityMapper = identityMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> registerClient(@RequestBody @Valid IdentityRequestDTO identityRegisterDTO) {
        Identity identity = this.identityMapper.requestDtoToDomain(identityRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.identityService.registerClient(identity));
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponseDTO> signIn(@RequestBody @Valid IdentityRequestDTO identityRequestDTO) throws BadRequestException {
        return ResponseEntity.ok(this.identityService.signIn(identityRequestDTO));
    }
}
