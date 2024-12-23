package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.Review;
import Ecommerce.example.Shopy.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User , UUID> {

}
