package gastocompartido.api.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "Testeos")
@Hidden
public class UserController {

    @Operation(
            description = "Es un endpoint para probar la API",
            summary = "Hello World test",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "403", description = "Unauthorized / Invalid Token"),
            }
    )
    @GetMapping("/login")
    public String loginUser() {

        return "Hello world!";
    }
}
