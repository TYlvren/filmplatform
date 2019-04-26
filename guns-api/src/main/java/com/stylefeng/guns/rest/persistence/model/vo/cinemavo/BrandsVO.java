package com.stylefeng.guns.rest.persistence.model.vo.cinemavo;

import java.io.Serializable;

public class BrandsVO implements Serializable {
    private static final long serialVersionUID = 6936086659515833906L;

    private int status;
    private Object data;

    public BrandsVO() {
    }


    public BrandsVO(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
