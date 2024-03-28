package gastocompartido.services;

import gastocompartido.api.entities.User;
import gastocompartido.api.services.JwtServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTests {
    @InjectMocks
    private JwtServiceImpl jwtServiceImpl;

    @Test
    public void testGetToken() {
        User user = new User();
        user.setUsername("testUser");

        String token = jwtServiceImpl.getToken(user);

        Assertions.assertNotNull(token);
        Assertions.assertTrue(token.length() > 0);
    }
}
