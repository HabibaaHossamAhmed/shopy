package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.Product_Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_PhotoRepository extends JpaRepository<Product_Photo, Integer> {
}