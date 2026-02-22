package dev.idinaldo.auth_api.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Identity")
public class JpaIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Username is required")
    @Column(nullable = false, unique = true)
    private String username;

    // NOTE: might be a good idea to improve this message
    @NotNull(message = "Password is required")
    @Column(nullable = false)
    private String passwordHash;
}
