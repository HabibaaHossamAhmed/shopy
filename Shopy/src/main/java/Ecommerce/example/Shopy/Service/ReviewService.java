package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Review;
import Ecommerce.example.Shopy.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ResponseEntity<Response<Review>> createReview(Review review) {
        // Save the review entity
        reviewRepository.save(review);
        // Create a custom response
        Response<Review> response = new Response<>(
                "Created Successfully!",
                HttpStatus.CREATED.value(),
                review
        );
        // Return the response wrapped in ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Response<Review>> deleteReview(Review review) {
        // delete the review entity
        reviewRepository.deleteById(review.getId());
        Response<Review> response = new Response<>(
                "Deleted Successfully!",
                HttpStatus.ACCEPTED.value(),
                review
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }





}
