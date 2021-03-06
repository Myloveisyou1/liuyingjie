package com.manji.msgservice.feign.response;

public class Message {
    private Integer code;
    private String message;
    private Object result;
    public Message() {}
    public Message(int code,String message,Object result){
        this.code = code;
        this.message = message;
        this.result = result;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
}
