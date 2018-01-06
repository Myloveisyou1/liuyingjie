package com.wx.farm.enums;

/**
 * @Author: 刘英杰
 * @Description: 返回值枚举
 * @Date: Created in 2017/12/26 13:38
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    ERROR_PASSWORD(100,"密码错误"),
    UNKNOW_ACCOUNT(101,"账户不存在"),
    NOT_LOGIN(102,"账户未登录或登陆已失效"),
    EMPTY_SESSIONID(104,"sessionId不能为空"),
    EMPTY_ERROR(404,"参数不全"),
    SUCCESS(1,"成功"),
    ERROR(0,"失败");
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
