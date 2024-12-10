package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.Cart;
import Ecommerce.example.Shopy.Entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart , UUID> {
    public Optional<Cart> getById(Cart cart);
}
