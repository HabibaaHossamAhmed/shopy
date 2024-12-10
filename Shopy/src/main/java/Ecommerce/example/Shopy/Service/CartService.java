package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Cart;
import Ecommerce.example.Shopy.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;


    public ResponseEntity<Response<Cart>> saveOrUpdateCart(Cart cart, String successMessage) {
        Cart savedCart = cartRepository.save(cart);
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, savedCart);
    }

    public ResponseEntity<Response<String>> deleteCart(Cart cart) {
        Optional<Cart> cartFound = cartRepository.findById(cart.getId());

        if (cartFound.isPresent()) {
            cartRepository.deleteById(cart.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "Cart ID: "
                    + cart.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Cart not found!", HttpStatus.NOT_FOUND, null);
        }
    }


}
