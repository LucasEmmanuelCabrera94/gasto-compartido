package gastocompartido.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Gasto Compartido",
		description = "Es una aplicacion para gestionar gastos." +
		"  <b>Git</b>: https://github.com/LucasEmmanuelCabrera94" +
		" <b>LinkedIn</b>: https://www.linkedin.com/in/lucasemmanuelcabrera", version = "1.0.0"))
public class GastoCompartidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GastoCompartidoApplication.class, args);
	}

}
