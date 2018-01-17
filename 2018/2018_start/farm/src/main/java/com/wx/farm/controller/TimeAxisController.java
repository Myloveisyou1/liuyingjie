package com.wx.farm.controller;

import com.wx.farm.domain.Result;
import com.wx.farm.domain.TimeAxis;
import com.wx.farm.enums.ResultEnum;
import com.wx.farm.service.TimeAxisService;
import com.wx.farm.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript: 时间轴控制层
 * @Author: liuyingjie
 * @Date: create in 2018/1/5 0005 14:21
 */
@RestController
@RequestMapping(value = "/timeAxis")
public class TimeAxisController {

    @Autowired
    private TimeAxisService service;

    /**
     * 添加时间轴
     * @param timeAxis
     * @return
     */
    @GetMapping(value = "/add")
    public Result addTimeAxis(TimeAxis timeAxis){

        int ret = service.addTimeAxis(timeAxis);
        if(ret > 0){
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMsg());
        }
    }

    /**
     * 查询时间轴
     * @param
     * @return
     */
    @GetMapping(value = "/findTimeAxisByPage")
    public Result findTimeAxisByPage(Integer pageSize,Integer pageNumber,String f_user){

        return ResultUtil.success(service.findTimeAxisByPage(pageSize,pageNumber,f_user));

    }

}
