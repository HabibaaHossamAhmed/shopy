package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.SubCategory;
import Ecommerce.example.Shopy.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {
    @Autowired
    SubCategoryService subCategoryService;

    @PostMapping
    public ResponseEntity<Response<SubCategory>> saveSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.saveOrUpdateSubCategory(subCategory, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<Response<SubCategory>> updateSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.saveOrUpdateSubCategory(subCategory, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<Response<String>> deleteSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.deleteSubCategory(subCategory);
    }
}
