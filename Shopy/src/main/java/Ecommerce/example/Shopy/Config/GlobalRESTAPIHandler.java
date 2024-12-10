package Ecommerce.example.Shopy.Config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalRESTAPIHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String>> handleGlobalException(Exception ex) {
        Response<String> response = new Response<>(
                "An error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    public  <T> ResponseEntity<Response<T>> createResponse(String message, HttpStatus status, T data) {
        Response<T> response = new Response<>(message, status.value(), data);
        return ResponseEntity.status(status).body(response);
    }
}
