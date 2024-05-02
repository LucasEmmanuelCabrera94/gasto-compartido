package gastocompartido.api.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name = "Lucas Emmanuel", email = "cabreraemmanuellucas@hotmail.com"),
                title = "Gasto Compartido",
                description = "Es una aplicacion para gestionar gastos." +
                    "  <b>Git</b>: https://github.com/LucasEmmanuelCabrera94" +
                    " <b>LinkedIn</b>: https://www.linkedin.com/in/lucasemmanuelcabrera",
                version = "1.0"
        ),
        servers = @Server(
                url = "http://localhost:8080", description = "Local Env"
        )
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
