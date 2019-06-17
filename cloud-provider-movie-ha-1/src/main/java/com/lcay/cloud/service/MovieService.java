package com.lcay.cloud.service;

import com.lcay.cloud.entity.Movie;
import com.lcay.cloud.mapper.MovieMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieService {
    @Autowired(required = false)
    MovieMapper movieMapper;

    public Movie queryMovieById(Integer id){
        return movieMapper.queryMovieById(id);
    }
    public Integer insertMovie(Movie movie){
        log.info("movie:"+movie);
        return movieMapper.insertMovie(movie);
    }
}
