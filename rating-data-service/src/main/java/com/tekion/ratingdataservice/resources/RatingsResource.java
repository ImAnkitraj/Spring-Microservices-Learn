package com.tekion.ratingdataservice.resources;

import com.tekion.ratingdataservice.models.Rating;
import com.tekion.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 5);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("123", 4), new Rating("234", 3));
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;

    }
}
