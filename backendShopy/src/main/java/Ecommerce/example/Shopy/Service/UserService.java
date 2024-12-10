package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.User;
import Ecommerce.example.Shopy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;

    public ResponseEntity<ResponseAPI<User>> saveOrUpdateUser(User user, String successMessage)
    {
        User savedUser = userRepository.save(user);
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, user);
    }

    public ResponseEntity<ResponseAPI<String>> deleteUser(User user) {
        Optional<User> userFound = userRepository.findById(user.getId());

        if (userFound.isPresent()) {
            userRepository.deleteById(user.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "user ID: "
                    + user.getId());
        } else {
            return globalRESTAPIHandler.createResponse("User not found!", HttpStatus.NOT_FOUND, null);
        }
    }
    public Page<User> findAllPaginated(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}