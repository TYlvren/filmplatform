package com.stylefeng.guns.rest.persistence.model.vo.commonvo;

import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;

public class MsgVO extends StatusVO {

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
