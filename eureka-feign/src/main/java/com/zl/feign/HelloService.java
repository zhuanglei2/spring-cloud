package com.zl.feign;

import com.zl.hystric.SchedualServiceHiHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by zhuangl
 * 2019/7/17 14:19
 */

@FeignClient(value = "provider-hi",fallback = SchedualServiceHiHystric.class)
public interface HelloService {

    @RequestMapping(value = "/user/say")
    String sayHello();
}
