package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Review;
import Ecommerce.example.Shopy.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Response<Review>> saveProduct(@RequestBody Review review) {
        return reviewService.saveOrUpdateReview(review, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<Response<Review>> updateProduct(@RequestBody Review review) {
        return reviewService.saveOrUpdateReview(review, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<Response<String>> deleteProduct(@RequestBody Review review) {
        return reviewService.deleteReview(review);
    }
}
