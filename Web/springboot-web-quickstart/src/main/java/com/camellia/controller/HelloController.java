package com.camellia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求处理类
 * @Datetime: 2024/6/30下午12:41
 * @author: Camellia.xioahua
 */

//表明是请求处理类
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello Spring Boot");
        return "Hello Spring Boot";
    }
}
