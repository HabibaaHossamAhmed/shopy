package Ecommerce.example.Shopy.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPI<T>{
    private String message;
    private int statusCode;
    private T data;

}
