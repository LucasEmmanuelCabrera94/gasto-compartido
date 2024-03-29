package gastocompartido.api.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends  RuntimeException{

    private String code;
    private HttpStatus status;

    public BusinessException(String code, HttpStatus status,String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
