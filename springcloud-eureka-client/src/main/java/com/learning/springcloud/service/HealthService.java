package com.learning.springcloud.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

@Service
public class HealthService implements HealthIndicator {

    private boolean status = true;

    public void updateServiceStatus(boolean status){
        this.status = status;
    }


    @Override
    public Health health() {
        if(status) {
            return new Health.Builder().up().build();
        }
        return new Health.Builder().down().build();
    }
}
