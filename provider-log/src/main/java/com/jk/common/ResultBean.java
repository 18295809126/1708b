package com.jk.common;

/**
 * 返回体
 */
public class ResultBean {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应消息体
     */
    private String msg;


    /**
     * 响应数据
     */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
