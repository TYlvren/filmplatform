package com.stylefeng.guns.rest.persistence.model.vo.commonvo;

import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;

public class MsgAndDataVO extends StatusVO {
    private static final long serialVersionUID = 1232032155615897402L;

    public MsgAndDataVO() {
    }

    private String msg;
    private Object data;

    public MsgAndDataVO(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public MsgAndDataVO(int status, String msg, Object data) {
        super(status);
        this.msg = msg;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
