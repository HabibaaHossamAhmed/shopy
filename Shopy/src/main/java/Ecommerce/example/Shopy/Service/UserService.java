package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.User;
import Ecommerce.example.Shopy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Response<User>> createUser(User user) {
        // Save the user entity
        userRepository.save(user);
        // Create a custom response
        Response<User> response = new Response<>(
                "Created Successfully!",
                HttpStatus.CREATED.value(),
                user
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    public ResponseEntity<Response<User>> deleteUser(User user) {
        userRepository.deleteById(user.getId());
        Response<User> response = new Response<>(
                "Deleted Successfully!",
                HttpStatus.CREATED.value(),
                user
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}