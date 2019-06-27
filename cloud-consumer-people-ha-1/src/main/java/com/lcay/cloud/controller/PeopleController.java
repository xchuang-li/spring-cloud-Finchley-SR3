package com.lcay.cloud.controller;

import com.lcay.cloud.entity.Movie;
import com.lcay.cloud.feign.GitHubFeignClient;
import com.lcay.cloud.feign.MovieFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
//    @HystrixCommand(fallbackMethod = "getMovieByIdFallback",
//    commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000"),
//            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "10000")},
//            threadPoolProperties = {
//                    @HystrixProperty(name = "coreSize",value = "1"),
//                    @HystrixProperty(name = "maxQueueSize",value = "10")})
    public Movie getMovieById(@PathVariable("id") Long id){
        return this.movieFeignClient.getMovieById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/movie/insertMovie")
    @ResponseBody
    public Integer insertMovie(Movie movie){
        return movieFeignClient.InsertMovie(movie);
    }

    @RequestMapping(value = "/search/repositories",method = RequestMethod.GET)
    @ResponseBody
    public String SearchRepo(@RequestParam("q") String q){
        return gitHubFeignClient.SearchRepo(q);
    }

//    public Movie getMovieByIdFallback(Long id){
//        Movie movie = new Movie();
//        movie.setId(id.intValue());
//        movie.setName("默认电影");
//        return movie;
//    }
}
