package com.stylefeng.guns.rest.persistence.model.vo;

import java.io.Serializable;

public abstract class StatusVO implements Serializable {
    private static final long serialVersionUID = 2023312165384065269L;

    private int status;

    public StatusVO() {
    }

    public StatusVO(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
