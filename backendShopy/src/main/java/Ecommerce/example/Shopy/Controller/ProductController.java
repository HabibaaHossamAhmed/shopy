package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Product;
import Ecommerce.example.Shopy.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseAPI<Product>> saveProduct(@RequestBody Product product,
                                                            @RequestBody List<MultipartFile> images) {
        return productService.saveOrUpdateProduct(product,images ,"Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<ResponseAPI<Product>> updateProduct(@RequestBody Product product,
                                                              @RequestBody List<MultipartFile> images) {
        return productService.saveOrUpdateProduct(product,images ,"Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<ResponseAPI<String>> deleteProduct(@RequestBody Product product) {
        return productService.deleteProduct(product);
    }
    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return productService.findAllPaginated(pageable);
    }
}

