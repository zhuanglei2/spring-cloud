package com.zl.controller;

import com.zl.feign.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhuangl
 * 2019/7/17 14:41
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String sayHi(){
        return helloService.sayHello();
    }
}
