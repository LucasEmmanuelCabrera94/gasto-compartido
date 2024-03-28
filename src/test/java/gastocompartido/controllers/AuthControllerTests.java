package gastocompartido.controllers;

import gastocompartido.api.controllers.AuthController;
import gastocompartido.api.entities.auth.AuthResponse;
import gastocompartido.api.entities.auth.LoginRequest;
import gastocompartido.api.entities.auth.RegisterRequest;
import gastocompartido.api.services.interfaces.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTests {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @Test
    public void testRegisterUser() {
        RegisterRequest registerRequest = RegisterRequest.builder().userName("username").password("password").build();
        AuthResponse expectedResponse = AuthResponse.builder().token("token").build();

        Mockito.when(authService.registerUser(registerRequest)).thenReturn(expectedResponse);

        ResponseEntity<AuthResponse> responseEntity = authController.registerUser(registerRequest);

        assertEquals(expectedResponse, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Mockito.verify(authService, Mockito.times(1)).registerUser(registerRequest);
    }

    @Test
    public void testLogin() {
        LoginRequest loginRequest = LoginRequest.builder().username("username").password("password").build();
        AuthResponse expectedResponse = AuthResponse.builder().token("token").build();

        Mockito.when(authService.login(loginRequest)).thenReturn(expectedResponse);

        ResponseEntity<AuthResponse> responseEntity = authController.login(loginRequest);

        assertEquals(expectedResponse, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Mockito.verify(authService, Mockito.times(1)).login(loginRequest);
    }
}

