package com.zl.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by zhuangl
 * 2019/7/17 11:05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/say")
    public String say(HttpServletRequest request){
        return this.getClass().getName()+":"+"端口："+request.getServerPort();
    }

}
