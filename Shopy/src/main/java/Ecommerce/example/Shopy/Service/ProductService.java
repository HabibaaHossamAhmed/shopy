package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Product;
import Ecommerce.example.Shopy.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;

    public ResponseEntity<Response<Product>> saveOrUpdateProduct(Product product, String successMessage) {
        Product savedProduct = productRepository.save(product);
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, savedProduct);
    }

    public ResponseEntity<Response<String>> deleteProduct(Product product) {
        Optional<Product> productFound = productRepository.findById(product.getId());

        if (productFound.isPresent()) {
            productRepository.deleteById(product.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "Cart ID: "
                    + product.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Product not found!", HttpStatus.NOT_FOUND, null);
        }
    }
}
