package com.stylefeng.guns.rest.persistence.model.vo.uservo;

public class UserVO {
    private int status;
    private Object data;

    public UserVO() {
    }

    public UserVO(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
