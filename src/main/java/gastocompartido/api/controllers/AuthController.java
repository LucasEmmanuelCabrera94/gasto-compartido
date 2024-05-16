package gastocompartido.api.controllers;

import gastocompartido.api.entities.auth.AuthResponse;
import gastocompartido.api.entities.auth.LoginRequest;
import gastocompartido.api.entities.auth.RegisterRequest;
import gastocompartido.api.services.interfaces.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autoritation endpoints")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @Operation(
            description = "Puede registrar un nuevo usuario para usar la api.",
            summary = "Crea AQUI un usuario para poder tener token y usar la api.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
            }
    )
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody RegisterRequest user) {
         return ResponseEntity.ok(authService.registerUser(user));
    }

    @Operation(
            description = "Puede logear para obtener Token.",
            summary = "Si ya posee un usuario, puede iniciar sesion.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "User not found"),
            }
    )
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
