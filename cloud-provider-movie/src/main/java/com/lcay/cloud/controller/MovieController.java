package com.lcay.cloud.controller;

import com.lcay.cloud.entity.Movie;
import com.lcay.cloud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/{id}")
    public Movie queryMovieById(@PathVariable Integer id){
        return movieService.queryMovieById(id);
    }

    @RequestMapping(value = "/insertMovie",method = RequestMethod.POST,consumes = "application/json")
    public Integer insertMovie(@RequestBody Movie movie){
        return movieService.insertMovie(movie);
    }
}
