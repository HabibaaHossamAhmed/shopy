package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category , Integer> {
}
