package com.lcay.cloud.feign;

import com.lcay.cloud.entity.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "movie-provider",configuration = FeignConfiguration.class)
public interface MovieFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable("id") Long id);

    @RequestMapping(value = "/insertMovie",method = RequestMethod.POST)
    public Integer InsertMovie(Movie movie);
}
