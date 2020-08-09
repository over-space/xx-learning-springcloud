package com.learning.springcloud.service;

import com.learning.springcloud.user.service.UserAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("eureka-client")
public interface UserService extends UserAPI {

}
