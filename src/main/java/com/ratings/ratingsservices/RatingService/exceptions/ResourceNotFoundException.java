package com.ratings.ratingsservices.RatingService.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException() {
        super("resource not found on server!!");
    }
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
