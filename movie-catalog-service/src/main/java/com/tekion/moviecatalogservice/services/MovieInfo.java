package com.tekion.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tekion.moviecatalogservice.models.Movie;
import com.tekion.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class MovieInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackMovie")
    public Movie getMovie(Rating r) {
        return restTemplate.getForObject("http://movie-info-service/movies/" + r.getMovieId(), Movie.class);
    }

    public Movie getFallbackMovie(Rating r) {
        return new Movie("0", "No Movie");
    }
}
