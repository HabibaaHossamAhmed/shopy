package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Product_Photo;
import Ecommerce.example.Shopy.Repository.Product_PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Product_PhotoService {
    @Autowired
    Product_PhotoRepository productPhotoRepository;
        public ResponseEntity<Response<Product_Photo>> createPhoto_product(Product_Photo productPhoto) {
            productPhotoRepository.save(productPhoto);
        // Create a custom response
        Response<Product_Photo> response = new Response<>(
                "Created Successfully!",
                HttpStatus.CREATED.value(),
                productPhoto
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    public ResponseEntity<Response<Product_Photo>> deletePhoto_product(Product_Photo productPhoto) {
        productPhotoRepository.deleteById(productPhoto.getId());
        Response<Product_Photo> response = new Response<>(
                "Deleted Successfully!",
                HttpStatus.CREATED.value(),
                productPhoto
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
