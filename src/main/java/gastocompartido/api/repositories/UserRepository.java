package gastocompartido.api.repositories;

import gastocompartido.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by the given username.
     *
     * @param  username   the username to search for
     * @return            an optional containing the user if found, empty otherwise
     */
    Optional<User> findByUsername(String username);
}
