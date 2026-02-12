package com.ratings.ratingsservices.RatingService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ratings {
    @Id
    private String ratingID;
    private String userId;
    private String hotelId;
    private int rating;
    private String remark;
}
