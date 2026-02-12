package com.ratings.ratingsservices.RatingService.repository;


import com.ratings.ratingsservices.RatingService.entities.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Ratings,String> {
    List<Ratings> findRatingsByUserId(String userId);

    Ratings findRatingsByHotelId(String hotelId);
}
