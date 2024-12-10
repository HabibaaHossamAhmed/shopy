package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Category;
import Ecommerce.example.Shopy.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Response<Category>> saveCategory(@RequestBody Category category) {
        return categoryService.saveOrUpdateCategory(category, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<Response<Category>> updateCategory(@RequestBody Category category) {
        return categoryService.saveOrUpdateCategory(category, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<Response<String>> deleteCategory(@RequestBody Category category) {
        return categoryService.deleteCategory(category);
    }
}
