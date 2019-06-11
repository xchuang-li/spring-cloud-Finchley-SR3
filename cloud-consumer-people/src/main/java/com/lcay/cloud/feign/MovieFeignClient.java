package com.lcay.cloud.feign;

import com.lcay.cloud.entity.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "movie-provider")
public interface MovieFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable("id") Long id);
}
