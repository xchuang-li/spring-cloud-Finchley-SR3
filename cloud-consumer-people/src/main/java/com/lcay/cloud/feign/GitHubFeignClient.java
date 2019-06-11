package com.lcay.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="github-client",url = "https://api.github.com")
public interface GitHubFeignClient {
    @RequestMapping(value = "/search/repositories",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String SearchRepo(@RequestParam("q") String q);
}
