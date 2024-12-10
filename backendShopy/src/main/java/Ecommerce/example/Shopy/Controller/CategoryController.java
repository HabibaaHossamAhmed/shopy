package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Category;
import Ecommerce.example.Shopy.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ResponseAPI<Category>> saveCategory(@RequestBody Category category) {
        return categoryService.saveOrUpdateCategory(category, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<ResponseAPI<Category>> updateCategory(@RequestBody Category category) {
        return categoryService.saveOrUpdateCategory(category, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<ResponseAPI<String>> deleteCategory(@RequestBody Category category) {
        return categoryService.deleteCategory(category);
    }
    @GetMapping
    public Page<Category> getAllCategoriesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return categoryService.findAllPaginated(pageable);
    }
}
