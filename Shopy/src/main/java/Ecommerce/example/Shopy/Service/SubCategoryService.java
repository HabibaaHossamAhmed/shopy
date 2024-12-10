package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.SubCategory;
import Ecommerce.example.Shopy.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;

    public ResponseEntity<Response<SubCategory>> saveOrUpdateSubCategory(SubCategory subCategory, String successMessage)
    {
        SubCategory savedSubCategory = subCategoryRepository.save(subCategory);
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, subCategory);
    }

    public ResponseEntity<Response<String>> deleteSubCategory(SubCategory subCategory) {
        Optional<SubCategory> subCategoryFound = subCategoryRepository.findById(subCategory.getId());

        if (subCategoryFound.isPresent()) {
            subCategoryRepository.deleteById(subCategory.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "Subcategory" +
                    " ID: "
                    + subCategory.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Subcategory not found!", HttpStatus.NOT_FOUND,
                    null);
        }
    }
}
