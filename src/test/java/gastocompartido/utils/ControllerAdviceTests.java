package gastocompartido.utils;

import gastocompartido.api.dto.ErrorDTO;
import gastocompartido.api.exceptions.BadRequestException;
import gastocompartido.api.utils.ControllerAdvice;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerAdviceTests {

    private final ControllerAdvice controllerAdvice = new ControllerAdvice();

    @Test
    public void testRuntimeExceptionHandler() {
        String errorMessage = "Runtime error message";

        ResponseEntity<String> responseEntity = controllerAdvice.runtimeExceptionHandler(new RuntimeException(errorMessage));

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
    }

    @Test
    public void testBusinessExceptionHandler() {
        String errorCode = "400";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String errorMessage = "Business error message";

        ResponseEntity<ErrorDTO> responseEntity = controllerAdvice.badRequestExceptionHandler(new BadRequestException(status, errorMessage));

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(errorCode, responseEntity.getBody().getCode());
        assertEquals(errorMessage, responseEntity.getBody().getMessage());
    }
}
