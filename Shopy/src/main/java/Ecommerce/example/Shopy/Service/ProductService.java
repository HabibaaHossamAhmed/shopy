package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Product;
import Ecommerce.example.Shopy.Entity.Product_Photo;
import Ecommerce.example.Shopy.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<Response<Product>> createProduct(Product product) {
        productRepository.save(product);
        // Create a custom response
        Response<Product> response = new Response<>(
                "Created Successfully!",
                HttpStatus.CREATED.value(),
                product
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Response<Product>> deleteProduct(Product product) {
        productRepository.deleteById(product.getId());
        Response<Product> response = new Response<>(
                "Deleted Successfully!",
                HttpStatus.CREATED.value(),
                product
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
