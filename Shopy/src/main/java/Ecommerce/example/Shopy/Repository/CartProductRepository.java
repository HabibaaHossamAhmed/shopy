package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct , Long> {
}
