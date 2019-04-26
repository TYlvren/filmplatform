package com.stylefeng.guns.rest.persistence.model.vo.commonvo;

import java.io.Serializable;

public class MsgVO extends StatusVO implements Serializable {

    private static final long serialVersionUID = -3439842550822596019L;

    private String msg;

    public MsgVO() {
    }

    public MsgVO(int status, String msg) {
        super(status);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
