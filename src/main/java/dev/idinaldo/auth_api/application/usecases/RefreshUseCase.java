package dev.idinaldo.auth_api.application.usecases;

import dev.idinaldo.auth_api.adapters.out.dtos.RefreshTokenResponseDTO;
import dev.idinaldo.auth_api.domain.models.Identity;


/** <h1>Refresh Token Use Case</h1>
 * <p>RefreshUseCase is an interface which abstracts the use case of refreshing an Access Token
 * and therefore rotating the current refresh token.</p>

 * <p style="font-size: 12px; font-weight: bold;">Refreshing an Access Token consists of:
 * <ol>
 *  <li>generating a new non-expired short-lived Access Token.</li>
 * </ol>

 *<p style="font-size: 12px; font-weight: bold;">Rotating a Refresh Token consists of:</p>
 * <ol>
    *<li>Invalidating the current Refresh Token</li>
    *<li>Generating a new long-lived Refresh Token</li>
    *<li>Persisting it in our database</li>
 * </ol>
 *
 * <p style="font-size: 12px; font-weight: bold;">Return Type</p>
 * <p>The implementation of this use case is supposed to return a RefreshTokenResponseDTO which consists of</p>
 * <ul>
 *     <li>A new non-expired, short-lived Access Token</li>
 *     <li>A new non-expired, long-lived, persisted Refresh Token</li>
 * </ul>
 */
public interface RefreshUseCase {
    RefreshTokenResponseDTO refreshToken(Identity identity);
}
