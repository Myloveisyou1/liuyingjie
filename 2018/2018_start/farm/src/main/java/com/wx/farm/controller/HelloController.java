package com.wx.farm.controller;

import com.wx.farm.properties.GirlProperties;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = "/hello")
    public String hello(Integer id){
        return girlProperties.getCupSize();
    }
}
