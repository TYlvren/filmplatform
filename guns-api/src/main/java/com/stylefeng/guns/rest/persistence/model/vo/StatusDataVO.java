package com.stylefeng.guns.rest.persistence.model.vo;

import java.io.Serializable;

public class StatusDataVO implements Serializable {
    private static final long serialVersionUID = 1812634779860025916L;

    private int status;
    private Object data;


    public StatusDataVO() {
    }

    public StatusDataVO(int status, Object data) {
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
