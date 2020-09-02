package com.learning.springcloud.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class LimitRateFilter extends ZuulFilter {

    public static final String LIMIT_RATE_KEY = "limit";

    private static final RateLimiter rateLimiter = RateLimiter.create(5);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        if(!rateLimiter.tryAcquire()){
            System.out.println("当前用户访问量过大，被限流！");
            currentContext.set("LIMIT_RATE_KEY", false);
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -100;
    }
}
