package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.Review;
import Ecommerce.example.Shopy.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory , Long> {
  public Optional<SubCategory> getById(SubCategory subCategory);

}
