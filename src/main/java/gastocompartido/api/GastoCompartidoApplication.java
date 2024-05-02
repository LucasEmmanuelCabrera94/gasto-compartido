package gastocompartido.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GastoCompartidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GastoCompartidoApplication.class, args);
	}

}
