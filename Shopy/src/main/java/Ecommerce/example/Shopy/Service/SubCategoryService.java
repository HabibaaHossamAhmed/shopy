package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Review;
import Ecommerce.example.Shopy.Entity.SubCategory;
import Ecommerce.example.Shopy.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    public ResponseEntity<Response<SubCategory>> createSubCategory(SubCategory subCategory) {
        // Save the review entity
        subCategoryRepository.save(subCategory);
        // Create a custom response
        Response<SubCategory> response = new Response<>(
                "Created Successfully!",
                HttpStatus.CREATED.value(),
                subCategory
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Response<SubCategory>> deleteSubCategory(SubCategory subCategory) {
        // delete the review entity
        subCategoryRepository.deleteById(subCategory.getId());
        Response<SubCategory> response = new Response<>(
                "Deleted Successfully!",
                HttpStatus.ACCEPTED.value(),
                subCategory
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
