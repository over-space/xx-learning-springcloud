package com.learning.springcloud.feign.rule;

import com.learning.springcloud.feign.util.ThreadLocalUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class GrayAspect {

    //@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    @Pointcut("execution(* com.learning.springcloud.feign.controller..*.*(..))")
    public void anyMethod(){}

    @Before("anyMethod()")
    public void process(JoinPoint point){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String version = request.getParameter("version");

        Map<String, String> map = new HashMap<>(1);
        map.put("version", "v1");
        ThreadLocalUtil.set(map);
    }

}
