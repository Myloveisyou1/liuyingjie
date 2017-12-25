package com.love.entity;

import java.io.Serializable;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2017/12/19 0019 17:01
 */
public class WordsEntity implements Serializable{

    private Integer gid;

    private String content;

    private String createTime;

    private Integer version;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
