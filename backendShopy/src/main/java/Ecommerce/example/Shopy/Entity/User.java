package Ecommerce.example.Shopy.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty(message = "Name must not be empty or null")
    private String name;

    @Email
    @NotEmpty(message = "Email must not be empty or null")
    private String email;

    @NotEmpty(message = "Password must not be empty or null")
    private String password;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private String number;

    private String country;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @ManyToMany(mappedBy = "user_product")
    private Set<Product> productSet;

    @OneToMany
    private Set<Order> order_id;

    @OneToMany(mappedBy = "userReview")
    private Set<Review> userReviews;


    public enum RoleType {
        CallCenter ,
        Client,
        Shipment_Company,
        Seller
    }
}
