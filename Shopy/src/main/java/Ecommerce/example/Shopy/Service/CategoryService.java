package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Category;
import Ecommerce.example.Shopy.Entity.User;
import Ecommerce.example.Shopy.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ResponseEntity<Response<Category>> createCategory(Category category) {
        categoryRepository.save(category);
        // Create a custom response
        Response<Category> response = new Response<>(
                "Created Successfully!",
                HttpStatus.CREATED.value(),
                category
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Response<Category>> deleteCategory(Category category) {
        categoryRepository.deleteById(category.getId());
        Response<Category> response = new Response<>(
                "Deleted Successfully!",
                HttpStatus.CREATED.value(),
                category
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
