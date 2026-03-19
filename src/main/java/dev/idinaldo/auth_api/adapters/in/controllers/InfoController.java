package dev.idinaldo.auth_api.adapters.in.controllers;

import dev.idinaldo.auth_api.domain.models.Identity;
import dev.idinaldo.auth_api.ports.IdentityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class InfoController {

    private final IdentityRepository identityRepository;

    public InfoController(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    @GetMapping("users")
    public ResponseEntity<List<Identity>> getUsers() {
        return ResponseEntity.ok(this.identityRepository.findAll());
    }
}