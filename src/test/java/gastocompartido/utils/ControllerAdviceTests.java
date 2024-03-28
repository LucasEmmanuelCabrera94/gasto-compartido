package gastocompartido.utils;

import gastocompartido.api.dto.ErrorDTO;
import gastocompartido.api.exceptions.BusinessException;
import gastocompartido.api.utils.ControllerAdvice;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerAdviceTests {

    private final ControllerAdvice controllerAdvice = new ControllerAdvice();

    @Test
    public void testRuntimeExceptionHandler() {
        // Arrange
        String errorMessage = "Runtime error message";

        // Act
        ResponseEntity<String> responseEntity = controllerAdvice.runtimeExceptionHandler(new RuntimeException(errorMessage));

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
    }

    @Test
    public void testBusinessExceptionHandler() {
        // Arrange
        String errorCode = "400";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String errorMessage = "Business error message";

        // Act
        ResponseEntity<ErrorDTO> responseEntity = controllerAdvice.businessExceptionHandler(new BusinessException(errorCode, status, errorMessage));

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(errorCode, responseEntity.getBody().getCode());
        assertEquals(errorMessage, responseEntity.getBody().getMessage());
    }
}
