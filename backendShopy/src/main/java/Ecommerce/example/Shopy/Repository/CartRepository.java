package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.Cart;
import Ecommerce.example.Shopy.Entity.CartProduct;
import Ecommerce.example.Shopy.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart , UUID> {
    public ArrayList<Cart> findAllByUser(User user);
}
