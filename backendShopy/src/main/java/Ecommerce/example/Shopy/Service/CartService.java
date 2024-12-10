package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Cart;
import Ecommerce.example.Shopy.Entity.User;
import Ecommerce.example.Shopy.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;


    public ResponseEntity<ResponseAPI<Cart>> saveOrUpdateCart(Cart cart, String successMessage) {
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, cartRepository.save(cart));
    }

    public ResponseEntity<ResponseAPI<String>> deleteCart(Cart cart) {
        Optional<Cart> cartFound = cartRepository.findById(cart.getId());

        if (cartFound.isPresent()) {
            cartRepository.deleteById(cart.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "Cart ID: "
                    + cart.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Cart not found!", HttpStatus.NOT_FOUND, null);
        }
    }
    public ResponseEntity<ResponseAPI<ArrayList<Cart>>> getAllCartForUser(User user) {
        return globalRESTAPIHandler.createResponse("Data fetched Successfully!", HttpStatus.OK, cartRepository.findAllByUser(user));
    }


}
