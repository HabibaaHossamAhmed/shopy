package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Cart;
import Ecommerce.example.Shopy.Entity.User;
import Ecommerce.example.Shopy.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping
    public ResponseEntity<ResponseAPI<Cart>> saveCart(@RequestBody Cart cart) {
        return cartService.saveOrUpdateCart(cart, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<ResponseAPI<Cart>> updateCart(@RequestBody Cart cart) {
        return cartService.saveOrUpdateCart(cart, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<ResponseAPI<String>> deleteCart(@RequestBody Cart cart) {
        return cartService.deleteCart(cart);
    }
    @GetMapping
    public ResponseEntity<ResponseAPI<ArrayList<Cart>>> getAllCartForUser(@RequestBody User user) {
    return cartService.getAllCartForUser(user);
    }
}
