package com.springboot.bean;

public class ResponseBean<T> {
    private int status;
    private String msg;
    private T data;

    public ResponseBean() {
    }

    public ResponseBean(T data, int status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseBean(T data) {
        super();
        this.status = 0;
        this.msg = "成功";
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg +
                '}';
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
