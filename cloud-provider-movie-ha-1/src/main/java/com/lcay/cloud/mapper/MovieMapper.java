package com.lcay.cloud.mapper;

import com.lcay.cloud.entity.Movie;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MovieMapper {
    @Select("select id,name,count,balance from movie where id = #{id}")
    Movie queryMovieById(Integer id);
    @Insert("insert into movie(id,name,count,balance) values(null,#{name},#{count},#{balance})")
    Integer insertMovie(Movie movie);
}
