package com.ratings.ratingsservices.RatingService.service;

import com.ratings.ratingsservices.RatingService.entities.Ratings;
import com.ratings.ratingsservices.RatingService.exceptions.ResourceNotFoundException;

import java.util.List;

public interface RatingService {
    Ratings saveRatings(Ratings ratings);
    List<Ratings> getAllRatings();
    Ratings getRatingsById(String ratingId) throws ResourceNotFoundException;
    List<Ratings> getRatingsByUserId(String userId) throws ResourceNotFoundException;
    Ratings getRatingsByHotelId(String hotelId) throws ResourceNotFoundException;
}
