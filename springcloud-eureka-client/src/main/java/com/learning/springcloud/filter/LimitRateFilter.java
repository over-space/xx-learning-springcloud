package com.learning.springcloud.filter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LimitRateFilter implements Filter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(1);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (RATE_LIMITER.tryAcquire()) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            servletResponse.setCharacterEncoding("utf-8");
            servletResponse.setContentType("text/html");
            PrintWriter pw = servletResponse.getWriter();
            pw.println("限流了");
            pw.close();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
