package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Category;
import Ecommerce.example.Shopy.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;


    public ResponseEntity<Response<Category>> saveOrUpdateCategory(Category category, String successMessage) {
        Category savedCategory = categoryRepository.save(category);
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, savedCategory);
    }

    public ResponseEntity<Response<String>> deleteCategory(Category category) {
        Optional<Category> categoryFound = categoryRepository.findById(category.getId());

        if (categoryFound.isPresent()) {
            categoryRepository.deleteById(category.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "Cart ID: "
                    + category.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Category not found!", HttpStatus.NOT_FOUND, null);
        }
    }
}
