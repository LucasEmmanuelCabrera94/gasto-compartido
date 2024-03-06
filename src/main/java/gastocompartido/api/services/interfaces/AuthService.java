package gastocompartido.api.services.interfaces;

import gastocompartido.api.entities.Auth.AuthResponse;
import gastocompartido.api.entities.Auth.LoginRequest;
import gastocompartido.api.entities.Auth.RegisterRequest;
import gastocompartido.api.entities.User;

public interface AuthService {

    /**
     * Register a new user.
     *
     * @param  user  the user to register
     * @return       the authentication response
     */
    AuthResponse registerUser(RegisterRequest user);
    /**
     * A method to handle user login.
     *
     * @param  request   the login request containing username and password
     * @return          an authentication response containing a token
     */
    AuthResponse login(LoginRequest request);


}
