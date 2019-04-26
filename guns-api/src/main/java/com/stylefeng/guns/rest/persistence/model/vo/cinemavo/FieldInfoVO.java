package com.stylefeng.guns.rest.persistence.model.vo.cinemavo;

import java.io.Serializable;

public class FieldInfoVO implements Serializable {
    private static final long serialVersionUID = -6457699894693170254L;

    private int status;
    private String imgPre;
    private Object data;

    public FieldInfoVO() {
    }

    public FieldInfoVO(int status, String imgPre, Object data) {
        this.status = status;
        this.imgPre = imgPre;
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

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
