package gastocompartido.services;

import gastocompartido.api.entities.Auth.AuthResponse;
import gastocompartido.api.entities.Auth.LoginRequest;
import gastocompartido.api.entities.Auth.RegisterRequest;
import gastocompartido.api.entities.User;
import gastocompartido.api.repositories.UserRepository;
import gastocompartido.api.services.AuthServiceImpl;
import gastocompartido.api.services.interfaces.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthServiceImpl authService;

    private RegisterRequest registerRequest;
    private LoginRequest loginRequest;

    @BeforeEach
    public void setup() {
        registerRequest = new RegisterRequest("testUser", "password", "Test", "User", "test@example.com", "Testland");
        loginRequest = new LoginRequest("testUser", "password");
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(jwtService.getToken(any(User.class))).thenReturn("testToken");

        AuthResponse response = authService.registerUser(registerRequest);

        assertNotNull(response);
        assertEquals("testToken", response.getToken());
        verify(userRepository, times(1)).save(any(User.class));
        verify(jwtService, times(1)).getToken(any(User.class));
    }

    @Test
    public void testLogin() {
        User user = new User();
        user.setPassword("encodedPassword");
        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));
        when(jwtService.getToken(user)).thenReturn("testToken");

        AuthResponse response = authService.login(loginRequest);

        assertNotNull(response);
        assertEquals("testToken", response.getToken());
        verify(authenticationManager, times(1)).authenticate(any());
        verify(jwtService, times(1)).getToken(user);
    }

    @Test
    public void testLogin_InvalidUser() {
        when(userRepository.findByUsername("testUser")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> authService.login(loginRequest));
        verify(authenticationManager, times(1)).authenticate(any());
        verify(jwtService, never()).getToken(any());
    }
}

