package com.stylefeng.guns.rest.persistence.model.bo.cinemabo;

import java.io.Serializable;

public class AreaBO implements Serializable {

    private static final long serialVersionUID = -4221005659296669965L;


    private int areaId;
    private String areaName;

    //表示是否选中状态
    private boolean isActive;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
