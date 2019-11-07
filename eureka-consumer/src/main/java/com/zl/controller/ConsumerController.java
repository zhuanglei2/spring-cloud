package com.zl.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Create by zhuangl
 * 2019/7/17 11:22
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 负载均衡
     * 需要将eureka-provider1 application:name:改为provider-hi
     * 需要将eureka-provider2 application:name:改为provider-hi
     * restTemplate远程调用
     * @return
     */
    @RequestMapping("/loginTest")
    @HystrixCommand(fallbackMethod = "hiError") //断路器，fallbackMethod为短路后执行方法
    public String loginTest(){
        String url = "http://provider-hi/user/say";
        return restTemplate.getForObject(url,String.class);
    }

    /**
     * restTemplate远程调用
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        String url = "http://provider-user/user/say";
        return restTemplate.getForObject(url,String.class);
    }

    public String hiError(){
        return "hi,sorry,error!";
    }
}
