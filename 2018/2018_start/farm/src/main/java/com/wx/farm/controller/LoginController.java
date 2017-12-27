package com.wx.farm.controller;

import com.wx.farm.domain.Result;
import com.wx.farm.domain.User;
import com.wx.farm.service.LoginService;
import com.wx.farm.utils.MD5Util;
import com.wx.farm.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 刘英杰
 * @Description: 登录控制层
 * @Date: Created in 2017/12/27 22:35
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService service;
    /**
     * 登录实现
     * @param userName
     * @param password
     * @return
     */
    @GetMapping(value = "/login")
    public Result login(String userName, String password){

        boolean flag = service.findUser(userName, MD5Util.getMD5(password));
        //1.加密密码 MD5加密算法
        if(flag){
            return ResultUtil.success();
        }
        return null;
    }
}
