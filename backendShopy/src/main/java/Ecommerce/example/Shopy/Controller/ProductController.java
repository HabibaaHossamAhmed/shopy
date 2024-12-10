package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Product;
import Ecommerce.example.Shopy.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseAPI<Product>> saveProduct(@RequestBody Product product) {
        return productService.saveOrUpdateProduct(product, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<ResponseAPI<Product>> updateProduct(@RequestBody Product product) {
        return productService.saveOrUpdateProduct(product, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<ResponseAPI<String>> deleteProduct(@RequestBody Product product) {
        return productService.deleteProduct(product);
    }
}

