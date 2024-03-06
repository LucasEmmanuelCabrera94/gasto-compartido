package gastocompartido.api.services.interfaces;

import gastocompartido.api.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    /**
     * Gets the token for the given user.
     *
     * @param  user	the user for whom the token is retrieved
     * @return      the token for the given user
     */
    String getToken(User user);

    /**
     * Get the username from the token.
     *
     * @param  token  the token from which to extract the username
     * @return       the username extracted from the token
     */
    String getUsernameFromToken(String token);

    /**
     * A method to check if the given token is valid for the given user details.
     *
     * @param  token       the token to be validated
     * @param  userDetails the user details for which the token is to be validated
     * @return            true if the token is valid, false otherwise
     */
    boolean isTokenValid(String token, UserDetails userDetails);
}
