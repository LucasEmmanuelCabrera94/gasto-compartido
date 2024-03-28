package gastocompartido.api.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends  RuntimeException{

    private HttpStatus status;

    public BadRequestException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
