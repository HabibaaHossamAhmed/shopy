package Ecommerce.example.Shopy.Config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalRESTAPIHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseAPI<String>> handleGlobalException(Exception ex) {
        ResponseAPI<String> response = new ResponseAPI<>(
                "An error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    public  <T> ResponseEntity<ResponseAPI<T>> createResponse(String message, HttpStatus status, T data) {
        ResponseAPI<T> response = new ResponseAPI<>(message, status.value(), data);
        return ResponseEntity.status(status).body(response);
    }
}
