package gastocompartido.api.utils;

import gastocompartido.api.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UsefulMethods {
    /**
     * Retrieves the currently logged-in user from the security context.
     *
     * @return         	The logged-in user object.
     */
    public static User getUserLogged() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
