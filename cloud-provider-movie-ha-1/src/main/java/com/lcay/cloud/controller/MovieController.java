package com.lcay.cloud.controller;

import com.lcay.cloud.entity.Movie;
import com.lcay.cloud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/{id}")
    public Movie queryMovieById(@PathVariable Integer id){
        return movieService.queryMovieById(id);
    }
}
