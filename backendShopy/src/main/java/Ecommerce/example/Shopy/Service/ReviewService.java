package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Product;
import Ecommerce.example.Shopy.Entity.Review;
import Ecommerce.example.Shopy.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public ResponseEntity<ResponseAPI<Review>> saveOrUpdateReview(Review review, String successMessage) {
        Review savedReview = reviewRepository.save(review);
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, savedReview);
    }

    public ResponseEntity<ResponseAPI<String>> deleteReview(Review review) {
        Optional<Review> reviewFound = reviewRepository.findById(review.getId());

        if (reviewFound.isPresent()) {
            reviewRepository.deleteById(review.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "review ID: "
                    + review.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Review not found!", HttpStatus.NOT_FOUND, null);
        }
    }
    public Page<Review> findAllPaginated(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }





}
