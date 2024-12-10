package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.Product;
import Ecommerce.example.Shopy.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review , Long> {
    public Optional<Review> getById(Review review);
}
