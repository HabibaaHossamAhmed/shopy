package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory , Long> {
}
