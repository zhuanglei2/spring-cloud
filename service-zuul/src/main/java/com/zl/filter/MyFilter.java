package com.zl.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务过滤
 * Create by zhuangl
 * 2019/7/18 15:40
 */
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    @Override
    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    public String filterType() {
        return "pre";
    }

    @Override
    /**
     * filterOrder：过滤的顺序
     */
    public int filterOrder() {
        return 0;
    }

    @Override
    /**
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     */
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken==null){
            log.info("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}
            return null;
        }
        log.info("ok");

        return null;
    }
}
