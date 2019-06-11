package com.lcay.cloud.service;

import com.lcay.cloud.entity.Movie;
import com.lcay.cloud.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired(required = false)
    MovieMapper movieMapper;

    public Movie queryMovieById(Integer id){
        return movieMapper.queryMovieById(id);
    }
}
