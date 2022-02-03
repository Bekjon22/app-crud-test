package uz.pdp.exception;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class RestException extends RuntimeException {

    private String message;

    private HttpStatus status;


    public RestException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public static RestException restThrow(String message, HttpStatus status) {
        return new RestException(message,status);
    }

    public static RestException notFound(String message) {
        return new RestException(message,HttpStatus.NOT_FOUND);
    }


}
