package com.lcay.sleuthservicesent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/tool")
public class ToolController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/square/{number}")
    public String square(@PathVariable("number") Integer number){
        return this.restTemplate.getForObject("http://localhost:18802/operation/square/"+number,String.class);
    }
}
