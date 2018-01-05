package com.wx.farm.service;

import com.wx.farm.domain.TimeAxis;
import com.wx.farm.enums.ResultEnum;
import com.wx.farm.exception.FarmException;
import com.wx.farm.mapper.TimeAxisMapper;
import com.wx.farm.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * @Descript: 时间轴实现层
 * @Author: liuyingjie
 * @Date: create in 2018/1/5 0005 14:33
 */
@Service
public class TimeAxisService {

    @Autowired
    private TimeAxisMapper mapper;
    /**
     * 添加时间轴
     * @param timeAxis
     * @return
     */
    public int addTimeAxis(TimeAxis timeAxis) {

        int ret = 0;
        if(CommonUtil.isNotEmpty(timeAxis)){
            timeAxis.setF_utime(timeAxis.getF_ctime());
            timeAxis.setF_version(1);
            ret = mapper.addTimeAxis(timeAxis);
        }else{
            throw new FarmException(ResultEnum.EMPTY_ERROR);
        }

        return ret;
    }
}
