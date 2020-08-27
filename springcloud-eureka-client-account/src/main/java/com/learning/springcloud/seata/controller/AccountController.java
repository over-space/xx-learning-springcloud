package com.learning.springcloud.seata.controller;

import com.learning.springcloud.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/debit")
    public void debit(@RequestParam(name = "userId") String userId, @RequestParam(name = "money") int money){
        accountService.debit(userId, money);
    }
}
