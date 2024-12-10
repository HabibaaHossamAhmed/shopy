package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.CartProduct;
import Ecommerce.example.Shopy.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product , UUID> {
}
