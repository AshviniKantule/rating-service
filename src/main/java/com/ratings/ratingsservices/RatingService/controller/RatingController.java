package com.ratings.ratingsservices.RatingService.controller;

import com.ratings.ratingsservices.RatingService.entities.Ratings;
import com.ratings.ratingsservices.RatingService.exceptions.ResourceNotFoundException;
import com.ratings.ratingsservices.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingService ratingService;
    @PostMapping("/create-ratings")
    public ResponseEntity<Ratings> createRatings(@RequestBody Ratings ratings){
        Ratings ratings1 = ratingService.saveRatings(ratings);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratings1);
    }

    @GetMapping("/get-ratings")
    public ResponseEntity<List<Ratings>> getAllUsers(){
       List<Ratings> list = ratingService.getAllRatings();
       return ResponseEntity.of(Optional.ofNullable(list));
    }
    @GetMapping("/get-ratings/{id}")
    public ResponseEntity<Ratings> getUserById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(ratingService.getRatingsById(id));
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Ratings>> getUserByUserId(@PathVariable String userId) throws ResourceNotFoundException {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }
    @GetMapping("/hotels/{hotel-id}")
    public ResponseEntity<Ratings> getUserByHotelId(@PathVariable("hotel-id") String hotelId) throws ResourceNotFoundException {
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }
}
