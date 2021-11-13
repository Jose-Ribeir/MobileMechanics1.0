package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
Iterable<Review> findByReviewClientId(int id);

}