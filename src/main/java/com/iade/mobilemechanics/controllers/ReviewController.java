package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Client;
import com.iade.mobilemechanics.models.Review;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.ClientRepository;
import com.iade.mobilemechanics.models.repositories.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/reviews")
public class ReviewController {
    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private ReviewRepository reviewRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Review> getReviews(){
        logger.info("Send all reviews to Request");
        return reviewRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Review getReview(@PathVariable int id){
        logger.info("Send review with id "+ id + "to Request");
        Optional<Review> _review = reviewRepository.findById(id);
        if (!_review.isPresent()) throw
                new NotFoundException("" + id, "review", "id");
        else
            return _review.get();
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Review savedReview(@RequestBody Review review){
        Review savedReview = reviewRepository.save(review);
        logger.info("Save review id " + savedReview.getId() + " to Database");
        return savedReview;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteReview(@PathVariable int id){
        logger.info("Delete review with id "+ id + "to Request");
        reviewRepository.deleteById(id);
        return "Deleted";
    }

}
