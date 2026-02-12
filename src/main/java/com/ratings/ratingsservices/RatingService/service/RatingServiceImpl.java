package com.ratings.ratingsservices.RatingService.service;


import com.ratings.ratingsservices.RatingService.entities.Ratings;
import com.ratings.ratingsservices.RatingService.exceptions.ResourceNotFoundException;
import com.ratings.ratingsservices.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    RestTemplate restTemplate;


    @Override
    public Ratings saveRatings(Ratings ratings) {
        return ratingRepository.save(ratings);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Ratings getRatingsById(String ratingId) throws ResourceNotFoundException {
        return ratingRepository.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("rating id is not found:"+ratingId));
    }

    @Override
    public List<Ratings> getRatingsByUserId(String userId) throws ResourceNotFoundException {
       // String url = "http://localhost:8081/users/get-user/"+userId;
       // Ratings ratings =restTemplate.getForObject(url,Ratings.class);
        return ratingRepository.findRatingsByUserId(userId);
    }

    @Override
    public Ratings getRatingsByHotelId(String hotelId) throws ResourceNotFoundException {
       // String url = "http://localhost:8083/hotels/get-hotel/"+hotelId;
       // Ratings ratings =restTemplate.getForObject(url,Hotel.class);
        return ratingRepository.findRatingsByHotelId(hotelId);
    }
}
