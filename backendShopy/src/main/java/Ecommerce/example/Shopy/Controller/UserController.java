package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.User;
import Ecommerce.example.Shopy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<ResponseAPI<User>> saveUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<ResponseAPI<User>> updateUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<ResponseAPI<String>> deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }
    @GetMapping
    public Page<User> getAllUsersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return userService.findAllPaginated(pageable);
    }
}
