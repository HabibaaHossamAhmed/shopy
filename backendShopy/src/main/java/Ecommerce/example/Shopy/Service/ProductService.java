package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Product;
import Ecommerce.example.Shopy.Entity.Product_Photo;
import Ecommerce.example.Shopy.Repository.ProductRepository;
import Ecommerce.example.Shopy.Repository.Product_PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    Product_PhotoRepository productPhotoRepository;
    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;

    public ResponseEntity<ResponseAPI<Product>> saveOrUpdateProduct(Product product, List<MultipartFile> images, String
            successMessage) {
        // Save the product
        Product savedProduct = productRepository.save(product);

        // Process and save images
        for (MultipartFile image : images) {
            try {
                Product_Photo photo = new Product_Photo();
                photo.setImage(image.getBytes());
                photo.setProduct(savedProduct);
                productPhotoRepository.save(photo);
            } catch (IOException e) {
                throw new RuntimeException("Failed to save image", e);
            }
        }

        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, savedProduct);
    }

    public ResponseEntity<ResponseAPI<String>> deleteProduct(Product product) {
        Optional<Product> productFound = productRepository.findById(product.getId());

        if (productFound.isPresent()) {
            productRepository.deleteById(product.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "product ID: "
                    + product.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Product not found!", HttpStatus.NOT_FOUND, null);
        }
    }
    public Page<Product> findAllPaginated(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
