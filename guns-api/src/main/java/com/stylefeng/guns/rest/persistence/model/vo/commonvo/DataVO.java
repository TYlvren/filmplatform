package com.stylefeng.guns.rest.persistence.model.vo.commonvo;

import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;

import java.io.Serializable;

public class DataVO extends StatusVO implements Serializable {
    private static final long serialVersionUID = 1812634779860025916L;

    private Object data;

    public DataVO(){}

    public DataVO(int status, Object data) {
        super(status);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
