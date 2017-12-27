package com.wx.farm.service;

import com.wx.farm.domain.User;
import com.wx.farm.enums.ResultEnum;
import com.wx.farm.exception.FarmException;
import com.wx.farm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: 刘英杰
 * @Description:
 * @Date: Created in 2017/12/28 0:47
 */
@Component
@Service
public class LoginService {

    @Autowired
    private UserMapper mapper;

    public boolean findUser(String userName, String password) {
        User user = mapper.findUser(userName,password);
        if(mapper.findUserByName(userName) != null){
            if(user != null){
                return true;
            }else{
                throw new FarmException(ResultEnum.ERROR_PASSWORD);
            }
        }else{
            throw  new FarmException(ResultEnum.UNKNOW_ACCOUNT);
        }
    }
}
