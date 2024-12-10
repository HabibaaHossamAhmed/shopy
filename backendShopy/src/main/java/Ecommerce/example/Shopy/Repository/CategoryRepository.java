package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.CartProduct;
import Ecommerce.example.Shopy.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository <Category , Long> {
    public Optional<Category> getById(Category category);
}
