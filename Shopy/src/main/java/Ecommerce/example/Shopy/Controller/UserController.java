package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.User;
import Ecommerce.example.Shopy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Response<User>> saveUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<Response<User>> updateUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<Response<String>> deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }
}
