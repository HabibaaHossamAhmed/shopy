package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Cart;
import Ecommerce.example.Shopy.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping
    public ResponseEntity<Response<Cart>> saveCart(@RequestBody Cart cart) {
        return cartService.saveOrUpdateCart(cart, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<Response<Cart>> updateCart(@RequestBody Cart cart) {
        return cartService.saveOrUpdateCart(cart, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<Response<String>> deleteCart(@RequestBody Cart cart) {
        return cartService.deleteCart(cart);
    }
}
