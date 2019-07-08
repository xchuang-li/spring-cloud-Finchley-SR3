package com.lcay.sleuthservicereceived.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operation")
@Slf4j
public class OprtationController {

    @RequestMapping("/square/{number}")
    public String square(@PathVariable(value = "number") Integer number){
        log.info("number:"+number);
        Integer i = number * number;
        return String.valueOf(i);
    }
}
