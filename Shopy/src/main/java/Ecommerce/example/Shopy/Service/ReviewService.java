package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Review;
import Ecommerce.example.Shopy.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;

    public ResponseEntity<Response<Review>> saveOrUpdateReview(Review review, String successMessage) {
        Review savedReview = reviewRepository.save(review);
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, savedReview);
    }

    public ResponseEntity<Response<String>> deleteReview(Review review) {
        Optional<Review> reviewFound = reviewRepository.findById(review.getId());

        if (reviewFound.isPresent()) {
            reviewRepository.deleteById(review.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "Cart ID: "
                    + review.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Review not found!", HttpStatus.NOT_FOUND, null);
        }
    }





}
