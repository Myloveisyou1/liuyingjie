package com.wx.farm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Author: 刘英杰
 * @Description: 配置数据库
 * @Date: Created in 2017/12/27 23:13
 */
@Configuration
@PropertySource("classpath:application.yml")
public class DataSourceConfig {

    @Value("${mysql.datasource.driverClassName}")
    private String driver;
    @Value("${mysql.datasource.url}")
    private String url;
    @Value("${mysql.datasource.username}")
    private String username;
    @Value("${mysql.datasource.password}")
    private String password;

    @Bean
    public DataSource primaryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);//用户名
        dataSource.setPassword(password);//密码
        dataSource.setDriverClassName(driver);
        return dataSource;
    }
}
