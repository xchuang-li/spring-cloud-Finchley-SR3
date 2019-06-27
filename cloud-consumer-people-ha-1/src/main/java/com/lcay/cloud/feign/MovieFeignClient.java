package com.lcay.cloud.feign;

import com.lcay.cloud.entity.Movie;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "movie-provider",fallbackFactory = FeignClientFallbackFactory.class)
public interface MovieFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable("id") Long id);

    @RequestMapping(value = "/insertMovie",method = RequestMethod.POST)
    public Integer InsertMovie(Movie movie);
}
@Component
class MovieFeignClientFallback implements MovieFeignClient{
    @Override
    public Integer InsertMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie getMovieById(Long id) {
        Movie movie = new Movie();
        movie.setId(id.intValue());
        movie.setName("无电影");
        return movie;
    }
}

@Component
@Slf4j
class FeignClientFallbackFactory implements FallbackFactory<MovieFeignClient>{

    @Override
    public MovieFeignClient create(Throwable throwable) {
        return new MovieFeignClient() {
            @Override
            public Movie getMovieById(Long id) {
                log.info("fallback:reason was "+throwable);
                Movie movie = new Movie();
                movie.setId(id.intValue());
                movie.setName("无电影");
                return movie;
            }

            @Override
            public Integer InsertMovie(Movie movie) {
                return null;
            }
        };
    }
}