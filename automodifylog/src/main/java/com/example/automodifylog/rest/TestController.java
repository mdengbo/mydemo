package com.example.automodifylog.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author madengbo
 * @create 2019-04-01 17:30
 * @desc springboot 2.0 配置动态修改日志
 * @Version 1.0
 **/
@RestController
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @RequestMapping("/test")
    public String simple(){
        LOGGER.debug(" this is a debug");
        return "test";
    }
}
