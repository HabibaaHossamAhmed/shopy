package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.CartProduct;
import Ecommerce.example.Shopy.Repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartProductService {
    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;


    public ResponseEntity<ResponseAPI<CartProduct>> saveOrUpdateCartProduct(CartProduct cartProduct, String successMessage)
    {
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, cartProductRepository.save(cartProduct));
    }

    public ResponseEntity<ResponseAPI<String>> deleteCartProduct(CartProduct cartProduct) {
        Optional<CartProduct> cartProductFound = cartProductRepository.findById(cartProduct.getId());

        if (cartProductFound.isPresent()) {
            cartProductRepository.deleteById(cartProduct.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "Product " +
                    "Cart ID: "
                    + cartProduct.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Product in the cart is" +
                    "not found!", HttpStatus.NOT_FOUND, null);
        }
    }

}
