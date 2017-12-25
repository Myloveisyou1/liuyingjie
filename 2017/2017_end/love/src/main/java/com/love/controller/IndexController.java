package com.love.controller;

import com.love.entity.WordsEntity;
import com.love.mapper.WordsMapper;
import com.love.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private WordsService service;


    @RequestMapping("/test")
    public String index(){
        return "hello word!";
    }
}
