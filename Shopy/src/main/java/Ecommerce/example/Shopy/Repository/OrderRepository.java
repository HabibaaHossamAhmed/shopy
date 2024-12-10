package Ecommerce.example.Shopy.Repository;

import Ecommerce.example.Shopy.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order , UUID> {
}
