package com.stylefeng.guns.rest.persistence.model.vo;

import java.io.Serializable;

public class StatusVO implements Serializable {

    private static final long serialVersionUID = -3439842550822596019L;
    private int status;
    private String msg;

    public StatusVO() {
    }

    public StatusVO(int status, String msg) {
        this.status = status;
        this.msg = msg;
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
