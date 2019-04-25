package com.stylefeng.guns.rest.persistence.model.bo.cinemabo;

public class BrandBO {

    private int brandId;
    private String brandName;
    private boolean isActive;

    public BrandBO() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
