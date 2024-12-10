package Ecommerce.example.Shopy.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private shipmentProcess process;

    @ManyToOne
    private User user_id;

    @ManyToMany
    private Set<Product> products;



    public enum shipmentProcess {
        Ordered ,
        Shipping,
        delivered,
    }
}
