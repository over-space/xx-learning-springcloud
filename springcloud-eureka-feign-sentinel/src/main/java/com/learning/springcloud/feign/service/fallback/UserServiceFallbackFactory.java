package com.learning.springcloud.feign.service.fallback;

import com.learning.springcloud.feign.service.UserService;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceFallbackFactory.class);

    @Override
    public UserService create(Throwable throwable) {

        logger.info("==========================================");

        logger.info("msg:{}, class:{}", throwable.getMessage(), throwable.getClass());

        return new UserService(){
            @Override
            public List<String> list() {
                if(throwable instanceof FeignException.InternalServerError){
                    return Arrays.asList("a", "b", "c");
                }else if(throwable instanceof FeignException.ServiceUnavailable){
                    return Arrays.asList("b");
                }
                return new ArrayList<>();
            }

            @Override
            public Map<String, String> findById(String id) {
               return null;
            }
        };
    }
}
