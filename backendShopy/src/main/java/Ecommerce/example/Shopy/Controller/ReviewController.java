package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Order;
import Ecommerce.example.Shopy.Entity.Review;
import Ecommerce.example.Shopy.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ResponseAPI<Review>> saveProduct(@RequestBody Review review) {
        return reviewService.saveOrUpdateReview(review, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<ResponseAPI<Review>> updateProduct(@RequestBody Review review) {
        return reviewService.saveOrUpdateReview(review, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<ResponseAPI<String>> deleteProduct(@RequestBody Review review) {
        return reviewService.deleteReview(review);
    }
    @GetMapping
    public Page<Review> getAllReviewsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return reviewService.findAllPaginated(pageable);
    }
}
