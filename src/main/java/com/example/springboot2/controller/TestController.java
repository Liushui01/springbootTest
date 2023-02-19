package com.example.springboot2.controller;

import com.example.springboot2.bean.Account;
import com.example.springboot2.bean.City;
import com.example.springboot2.bean.User;
import com.example.springboot2.service.AccountService;
import com.example.springboot2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;
    @Autowired
    CityService cityService;


    @ResponseBody
    @GetMapping("/acct")
    public Account testsql(Long id){
        return accountService.getacctByid(id);
    }

    @ResponseBody
    @GetMapping("/city")
    public City getByid(Long id){
        return cityService.getByid(id);
    }

}
