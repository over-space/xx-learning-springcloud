package com.learning.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyZuulFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);

    public MyZuulFilter() {
        super();
    }


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if(token == null || token.length() == 0){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
            return null;
        }


        String version = request.getParameter("version");
        if(version != null && version.length() > 0){
            RibbonFilterContextHolder.getCurrentContext().add("version", version);
        }

        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
