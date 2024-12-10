package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Product_Photo;
import Ecommerce.example.Shopy.Repository.Product_PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Product_PhotoService {
    @Autowired
    Product_PhotoRepository productPhotoRepository;
    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;


    public ResponseEntity<ResponseAPI<Product_Photo>> saveOrUpdateProductPhoto(Product_Photo productPhoto, String
            successMessage) {
        Product_Photo savedProductPhoto = productPhotoRepository.save(productPhoto);
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, savedProductPhoto);
    }

    public ResponseEntity<ResponseAPI<String>> deleteProductPhoto(Product_Photo productPhoto) {
        Optional<Product_Photo> productPhotoFound = productPhotoRepository.findById(productPhoto.getId());

        if (productPhotoFound.isPresent()) {
            productPhotoRepository.deleteById(productPhoto.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "Photo ID: "
                    + productPhoto.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Product's photo  not found!", HttpStatus.NOT_FOUND,
                    null);
        }
    }
}
