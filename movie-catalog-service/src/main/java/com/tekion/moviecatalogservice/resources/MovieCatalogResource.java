package com.tekion.moviecatalogservice.resources;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tekion.moviecatalogservice.models.CatalogItem;
import com.tekion.moviecatalogservice.models.Movie;
import com.tekion.moviecatalogservice.models.Rating;
import com.tekion.moviecatalogservice.models.UserRating;
import com.tekion.moviecatalogservice.services.MovieInfo;
import com.tekion.moviecatalogservice.services.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder builder;

    @Autowired
    private UserRatingInfo userRatingInfo;

    @Autowired
    private MovieInfo movieInfo;

    //    @Autowired
    //    private DiscoveryClient discoveryClient;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        UserRating userRating = userRatingInfo.getUserRating(userId);

        return userRating.getRatings().stream().map(r -> {
            //            Movie movie = builder.build().get().uri("http://localhost:3000/movies/" + r.getMovieId()).retrieve()
            //                                 .bodyToMono(Movie.class).block();
            Movie movie = movieInfo.getMovie(r);
            return new CatalogItem(movie.getName(), "Fiction", r.getRating());
        }).collect(Collectors.toList());
    }
}
