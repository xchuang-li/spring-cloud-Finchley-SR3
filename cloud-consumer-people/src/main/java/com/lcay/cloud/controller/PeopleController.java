package com.lcay.cloud.controller;

import com.lcay.cloud.entity.Movie;
import com.lcay.cloud.feign.GitHubFeignClient;
import com.lcay.cloud.feign.MovieFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
public class PeopleController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    MovieFeignClient movieFeignClient;
    @Autowired
    GitHubFeignClient gitHubFeignClient;

//    @RequestMapping("/movie/{id}")
//    public Movie getMovieById(@PathVariable int id){
//        return this.restTemplate.getForObject("http://movie-provider/"+id,Movie.class);
//    }

    @RequestMapping("/movie/index")
    public String movieIndex(){
        return "movie";
    }

    @RequestMapping("/movie/getChoosedService")
    @ResponseBody
    public String getChoosedService(){
        ServiceInstance serviceInstance =
                this.loadBalancerClient.choose("movie-provider");
        StringBuilder sb = new StringBuilder();
        sb.append("host: ").append(serviceInstance.getHost()).append(", ");
        sb.append("port: ").append(serviceInstance.getPort()).append(", ");
        sb.append("uri: ").append(serviceInstance.getUri());
        return sb.toString();
    }

    @RequestMapping("/movie/{id}")
    @ResponseBody
    public Movie getMovieById(@PathVariable("id") Long id){
        return this.movieFeignClient.getMovieById(id);
    }

    @GetMapping("/movie/insertMovie")
    @ResponseBody
    public Integer insertMovie(@RequestParam String name,@RequestParam Integer count,@RequestParam double balance){
        log.info("name:"+name);
        log.info("count:"+count);
        log.info("balance:"+balance);
        Movie movie = new Movie();
        movie.setName(name);
        movie.setCount(count);
        movie.setBalance(balance);
        return movieFeignClient.InsertMovie(movie);
    }

    @RequestMapping(value = "/search/repositories",method = RequestMethod.GET)
    @ResponseBody
    public String SearchRepo(@RequestParam("q") String q){
        return gitHubFeignClient.SearchRepo(q);
    }
}
