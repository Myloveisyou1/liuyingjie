package com.wx.farm.handle;

import com.wx.farm.domain.Result;
import com.wx.farm.exception.FarmException;
import com.wx.farm.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 刘英杰
 * @Description: 异常捕获
 * @Date: Created in 2017/12/26 13:23
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){

        if(e instanceof FarmException){
            FarmException farmException = (FarmException) e;
            return ResultUtil.error(farmException.getCode(),farmException.getMessage());
        }else{
            logger.info("系统异常{}",e);
            return ResultUtil.error(-1,"系统繁忙,请稍后再试!");
        }
    }
}
