package com.zl.hystric;

import com.zl.feign.HelloService;
import org.springframework.stereotype.Component;

/**
 * Create by zhuangl
 * 2019/7/18 14:04
 */
@Component
public class SchedualServiceHiHystric implements HelloService {
    @Override
    public String sayHello() {
        return this.getClass().getName()+"sorry";
    }
}
