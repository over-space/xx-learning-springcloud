package com.learning.springcloud.feign.service.fallback;


import com.learning.springcloud.feign.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class UserServiceFallbackHystrix implements UserService {

    @Override
    public List<String> list() {
        return new ArrayList<>();
    }

    @Override
    public Map<String, String> findById(String id) {
        return new HashMap<>();
    }
}
