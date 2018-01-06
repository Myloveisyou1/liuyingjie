package com.wx.farm.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.farm.domain.User;
import com.wx.farm.enums.ResultEnum;
import com.wx.farm.exception.FarmException;
import com.wx.farm.mapper.UserMapper;
import com.wx.farm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public Map<String,Object> findUser(String userName, String password) {
        User user = mapper.findUser(userName,password);
        Map<String,Object> map = new HashMap<>();
        String sessionId = "";
        if(mapper.findUserByName(userName) != null){
            if(user != null){
                //先判断原来登陆是否失效
                if(stringRedisTemplate.hasKey("sessionId")){
                    if(stringRedisTemplate.hasKey(stringRedisTemplate.opsForValue().get("sessionId"))){
                        stringRedisTemplate.delete(stringRedisTemplate.opsForValue().get("sessionId"));
                    }
                }
                //保存session到redis
                sessionId = MD5Util.getMD5(new Date().toString());
                stringRedisTemplate.opsForValue().set("sessionId",sessionId);
                stringRedisTemplate.opsForValue().set(sessionId, JSONObject.toJSONString(user),1800, TimeUnit.SECONDS);
                map.put("sessionId",sessionId);
                map.put("user",user);
                return map;
            }else{
                throw new FarmException(ResultEnum.ERROR_PASSWORD);
            }
        }else{
            throw  new FarmException(ResultEnum.UNKNOW_ACCOUNT);
        }
    }

    /**
     * 校验登陆
     * @param sessionId
     * @return
     */
    public boolean check(String sessionId) {
        boolean f = false;
        boolean flag = stringRedisTemplate.hasKey(sessionId);
        if(flag){
            //重新设置session有效期
            String str = stringRedisTemplate.opsForValue().get(sessionId);
            stringRedisTemplate.opsForValue().set(sessionId, str,1800, TimeUnit.SECONDS);
            f = true;
        }else{
            throw new FarmException(ResultEnum.NOT_LOGIN);
        }
        return f;
    }

    /**
     * 退出登录
     * @param sessionId
     * @return
     */
    public boolean loginOut(String sessionId) {

        stringRedisTemplate.delete(sessionId);
        return true;
    }
}
