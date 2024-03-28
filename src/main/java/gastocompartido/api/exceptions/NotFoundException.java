package gastocompartido.api.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends  RuntimeException{

    private HttpStatus status;

    public NotFoundException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
