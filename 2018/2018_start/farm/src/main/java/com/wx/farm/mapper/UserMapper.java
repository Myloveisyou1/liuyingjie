package com.wx.farm.mapper;

import com.wx.farm.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: 刘英杰
 * @Description:
 * @Date: Created in 2017/12/28 0:42
 */
@Component
@Mapper
public interface UserMapper {

    @Select("select * from f_user where f_user_name=#{userName} and f_user_password=#{password}")
    User findUser(@Param("userName") String userName, @Param("password") String password);

    @Select("select * from f_user where f_user_name=#{userName}")
    User findUserByName(@Param("userName") String userName);
}
