package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.CartProduct;
import Ecommerce.example.Shopy.Entity.Product_Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Product_PhotoRepository extends JpaRepository<Product_Photo, Long> {
}
