package com.love;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2017/12/1 0001 11:13
 */
@SpringBootApplication //@EnableAutoConfiguration、@ComponentScan和@Configuration的合集。@EnableScheduling:表明是一个任务
@ServletComponentScan
//@EnableEurekaClient//启动eureka
@EnableScheduling//开启定时任务
//@EnableZuulProxy
@MapperScan("com.love.mapper")
public class LoveApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(LoveApplication.class, args);
    }
}
