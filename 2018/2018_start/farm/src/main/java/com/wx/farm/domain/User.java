package com.wx.farm.domain;

import java.util.Date;

/**
 * @Author: 刘英杰
 * @Description: 用户实体
 * @Date: Created in 2017/12/28 0:43
 */
public class User {
    private Integer fid;
    private String f_user_name;
    private String f_user_password;
    private String f_user_realname;
    private Date f_user_login_time;
    private Integer f_user_status;
    private Date f_user_create_time;
    private Date f_user_update_time;
    private Integer f_user_version;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getF_user_name() {
        return f_user_name;
    }

    public void setF_user_name(String f_user_name) {
        this.f_user_name = f_user_name;
    }

    public String getF_user_password() {
        return f_user_password;
    }

    public void setF_user_password(String f_user_password) {
        this.f_user_password = f_user_password;
    }

    public String getF_user_realname() {
        return f_user_realname;
    }

    public void setF_user_realname(String f_user_realname) {
        this.f_user_realname = f_user_realname;
    }

    public Date getF_user_login_time() {
        return f_user_login_time;
    }

    public void setF_user_login_time(Date f_user_login_time) {
        this.f_user_login_time = f_user_login_time;
    }

    public Integer getF_user_status() {
        return f_user_status;
    }

    public void setF_user_status(Integer f_user_status) {
        this.f_user_status = f_user_status;
    }

    public Date getF_user_create_time() {
        return f_user_create_time;
    }

    public void setF_user_create_time(Date f_user_create_time) {
        this.f_user_create_time = f_user_create_time;
    }

    public Date getF_user_update_time() {
        return f_user_update_time;
    }

    public void setF_user_update_time(Date f_user_update_time) {
        this.f_user_update_time = f_user_update_time;
    }

    public Integer getF_user_version() {
        return f_user_version;
    }

    public void setF_user_version(Integer f_user_version) {
        this.f_user_version = f_user_version;
    }
}
