package com.learning.springcloud.service.fallback;

import com.learning.springcloud.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserServiceHystrix implements UserService {

    @Override
    public List<String> list() {
        System.out.println("======================list");
        return new ArrayList<>();
    }

    @Override
    public Map<String, String> findById(String id) {
        System.out.println("======================findById");
        return new HashMap<>();
    }
}
