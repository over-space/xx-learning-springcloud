package com.learning.springcloud.seata.controller;

import com.learning.springcloud.seata.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/storage", produces = MediaType.APPLICATION_JSON_VALUE)
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/deduct")
    public void deduct(String commodityCode){
        storageService.deduct(commodityCode, 1);
    }
}
