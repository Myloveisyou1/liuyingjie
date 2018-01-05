package com.wx.farm.mapper;

import com.wx.farm.domain.TimeAxis;
import com.wx.farm.utils.SimpleInsertLangDriver;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Descript: 时间轴数据库操作层
 * @Author: liuyingjie
 * @Date: create in 2018/1/5 0005 14:43
 */
@Component
@Mapper
public interface TimeAxisMapper {

    @Insert("insert into f_time_axis (#{timeAxis})")
    @Lang(SimpleInsertLangDriver.class)
    int addTimeAxis(TimeAxis timeAxis);
}
