package dev.idinaldo.auth_api.ports;

import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository {

    void save();
}
